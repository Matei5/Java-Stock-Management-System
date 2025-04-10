import java.util.Scanner;
import model.*;
import service.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            AdresaService adresaService = new AdresaService();
            CategorieService categorieService = new CategorieService();
            ProdusService produsService = new ProdusService(categorieService, adresaService);
            ClientService clientService = new ClientService(adresaService);
            DistribuitorService distribuitorService = new DistribuitorService(adresaService);
            AngajatService angajatService = new AngajatService(adresaService);
            FacturaService facturaService = new FacturaService();

            boolean running = true;
            while (running) {
                System.out.println("\n--- MENIU ---");
                System.out.println("1. Adauga produs");
                System.out.println("2. Afiseaza produse");
                System.out.println("3. Cauta produs dupa nume");
                System.out.println("4. Sterge produs dupa ID");
                System.out.println("5. Sorteaza produse dupa pret");
                System.out.println("6. Filtrare produse dupa categorie");
                System.out.println("7. Actualizeaza stoc");
                System.out.println("8. Produse cu stoc sub un prag");
                System.out.println("9. Adauga client");
                System.out.println("10. Afiseaza clienti");
                System.out.println("11. Creeaza comanda pentru client");
                System.out.println("12. Afiseaza comenzile unui client");
                System.out.println("13. Genereaza factura");
                System.out.println("14. Adauga distribuitor");
                System.out.println("15. Afiseaza distribuitori");
                System.out.println("16. Adauga angajat");
                System.out.println("17. Afiseaza angajati");
                System.out.println("0. Iesire");

                System.out.print("Optiune: ");
                int opt = input.nextInt();
                input.nextLine();

                switch (opt) {
                    case 1 -> produsService.adaugaProdus(input);
                    case 2 -> produsService.afiseazaProduse();
                    case 3 -> produsService.cautaProdusDupaNume(input);
                    case 4 -> produsService.stergeProdusDupaId(input);
                    case 5 -> produsService.afiseazaProduseSortateDupaPret();
                    case 6 -> produsService.filtreazaProduseDupaCategorie(input);
                    case 7 -> produsService.actualizeazaStoc(input);
                    case 8 -> produsService.afiseazaProduseCuStocMic(input);
                    case 9 -> clientService.adaugaClient(input);
                    case 10 -> clientService.afiseazaTotiClientii();
                    case 11 -> {
                        Client client = clientService.cautaClientDupaId(input);
                        if (client != null) {
                            produsService.afiseazaProduse();
                            System.out.print("ID produs: ");
                            int idProdus = input.nextInt();
                            input.nextLine();

                            var produs = produsService.getProduse().stream()
                                    .filter(p -> p.getId() == idProdus)
                                    .findFirst()
                                    .orElse(null);

                            if (produs != null) {
                                clientService.adaugaComandaPentruClient(client, java.util.List.of(produs));
                            } else {
                                System.out.println("Produs inexistent.");
                            }
                        }
                    }
                    case 12 -> {
                        Client client = clientService.cautaClientDupaId(input);
                        if (client != null) {
                            clientService.afiseazaComenziClient(client);
                        }
                    }
                    case 13 -> facturaService.genereazaFactura(input, clientService);
                    case 14 -> distribuitorService.adaugaDistribuitor(input);
                    case 15 -> distribuitorService.afiseazaDistribuitori();
                    case 16 -> angajatService.adaugaAngajat(input);
                    case 17 -> angajatService.afiseazaAngajati();
                    case 0 -> {
                        running = false;
                        System.out.println("La revedere!");
                    }
                    default -> System.out.println("Optiune invalida.");
                }
            }
        }
    }
}
