package service;

import java.util.*;
import model.*;

public class ProdusService {
    private final List<Produs> produse = new ArrayList<>();
    private int nextId = 1;
    private final CategorieService categorieService;
    private final AdresaService adresaService;

    public ProdusService(CategorieService categorieService, AdresaService adresaService) {
        this.categorieService = categorieService;
        this.adresaService = adresaService;
    }

    public void adaugaProdus(Scanner input) {
        if (input == null) {
            throw new IllegalArgumentException("Scanner cannot be null");
        }

        System.out.print("Nume produs: ");
        String nume = input.nextLine();

        if (nume == null || nume.trim().isEmpty()) {
            System.out.println("Numele produsului nu poate fi gol.");
            return;
        }

        System.out.print("Pret: ");
        double pret = input.nextDouble();

        System.out.print("Cantitate: ");
        int cantitate = input.nextInt();
        input.nextLine();

        System.out.println("Categorie noua sau existenta?");
        System.out.print("1 - Selecteaza din lista\n2 - Adauga categorie noua\nAlegere: ");
        int opt = input.nextInt();
        input.nextLine();

        Categorie categorie = null;
        if (opt == 1) {
            categorieService.afiseazaCategorii();
            System.out.print("Categorie: ");
            String numeCat = input.nextLine();
            categorie = categorieService.cautaCategorieDupaNume(numeCat);
            if (categorie == null) {
                System.out.println("Categorie inexistenta. Se creeaza automat.");
                categorie = new Categorie(numeCat);
                categorieService.getCategorii().add(categorie);
            }
        } else {
            categorie = categorieService.adaugaCategorie(input);
        }

        System.out.print("Nume distribuitor: ");
        String numeDistribuitor = input.nextLine();

        System.out.println("Introduceti adresa distribuitorului:");
        Adresa adresa = adresaService.creeazaAdresa(input);
        Distribuitor distribuitor = new Distribuitor(numeDistribuitor, adresa);

        Produs produs = new Produs(nextId++, nume, pret, cantitate, categorie, distribuitor);
        produse.add(produs);

        System.out.println("Produs adaugat cu succes.");
    }

    public void afiseazaProduse() {
        if (produse.isEmpty()) {
            System.out.println("Nu exista produse in sistem.");
            return;
        }

        for (Produs p : produse) {
            System.out.println(p);
        }
    }

    public void cautaProdusDupaNume(Scanner input) {
        System.out.print("Nume cautat: ");
        String nume = input.nextLine();

        boolean gasit = false;
        for (Produs p : produse) {
            if (p.getNume().equalsIgnoreCase(nume)) {
                System.out.println(p);
                gasit = true;
            }
        }

        if (!gasit) {
            System.out.println("Produsul nu a fost gasit.");
        }
    }

    public void stergeProdusDupaId(Scanner input) {
        System.out.print("ID produs de sters: ");
        int id = input.nextInt();
        input.nextLine();

        Iterator<Produs> iterator = produse.iterator();
        boolean sters = false;

        while (iterator.hasNext()) {
            Produs p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                sters = true;
                System.out.println("Produs sters.");
                break;
            }
        }

        if (!sters) {
            System.out.println("Produsul cu ID-ul dat nu exista.");
        }
    }

    public void afiseazaProduseSortateDupaPret() {
        if (produse.isEmpty()) {
            System.out.println("Nu exista produse.");
            return;
        }

        List<Produs> produseSortate = new ArrayList<>(produse);
        produseSortate.sort(Comparator.comparingDouble(Produs::getPret));

        System.out.println("Produse sortate dupa pret:");
        for (Produs p : produseSortate) {
            System.out.println(p);
        }
    }

    public void filtreazaProduseDupaCategorie(Scanner input) {
        System.out.print("Categorie: ");
        String categorieCautata = input.nextLine();

        boolean gasit = false;
        for (Produs p : produse) {
            if (p.getCategorie().getNume().equalsIgnoreCase(categorieCautata)) {
                System.out.println(p);
                gasit = true;
            }
        }

        if (!gasit) {
            System.out.println("Nu exista produse in aceasta categorie.");
        }
    }

    public void actualizeazaStoc(Scanner input) {
        System.out.print("ID produs: ");
        int id = input.nextInt();

        System.out.print("Noua cantitate: ");
        int cantitateNoua = input.nextInt();
        input.nextLine();

        for (Produs p : produse) {
            if (p.getId() == id) {
                p.setCantitate(cantitateNoua);
                System.out.println("Stoc actualizat.");
                return;
            }
        }

        System.out.println("Produsul nu a fost gasit.");
    }

    public void afiseazaProduseCuStocMic(Scanner input) {
        System.out.print("Prag stoc: ");
        int prag = input.nextInt();
        input.nextLine();

        boolean gasit = false;
        for (Produs p : produse) {
            if (p.getCantitate() < prag) {
                System.out.println(p);
                gasit = true;
            }
        }

        if (!gasit) {
            System.out.println("Toate produsele au stoc suficient.");
        }
    }

    public List<Produs> getProduse() {
        return produse;
    }
}
