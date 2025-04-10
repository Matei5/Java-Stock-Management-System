package service;

import java.util.*;
import model.Adresa;
import model.Client;
import model.Comanda;
import model.Produs;

public class ClientService {
    private final List<Client> clienti = new ArrayList<>();
    private final Map<Integer, List<Comanda>> comenziClient = new HashMap<>();
    private final AdresaService adresaService;
    private int nextClientId = 1;
    private int nextComandaId = 1;

    public ClientService(AdresaService adresaService) {
        this.adresaService = adresaService;
    }

    public Client adaugaClient(Scanner input) {
        System.out.print("Nume client: ");
        String nume = input.nextLine();

        System.out.println("Introduceti adresa clientului:");
        Adresa adresa = adresaService.creeazaAdresa(input);

        Client client = new Client(nextClientId++, nume, adresa);
        clienti.add(client);
        comenziClient.put(client.getId(), new ArrayList<>());

        System.out.println("Client adaugat cu ID: " + client.getId());
        return client;
    }

    public void afiseazaTotiClientii() {
        if (clienti.isEmpty()) {
            System.out.println("Nu exista clienti.");
            return;
        }

        for (Client c : clienti) {
            System.out.println(c);
        }
    }

    public Client cautaClientDupaId(Scanner input) {
        System.out.print("ID client: ");
        int id = input.nextInt();
        input.nextLine();

        for (Client c : clienti) {
            if (c.getId() == id) return c;
        }

        System.out.println("Clientul nu a fost gasit.");
        return null;
    }

    public void afiseazaComenziClient(Client client) {
        List<Comanda> comenzi = comenziClient.get(client.getId());
        if (comenzi == null || comenzi.isEmpty()) {
            System.out.println("Clientul nu are comenzi.");
            return;
        }

        for (Comanda c : comenzi) {
            System.out.println(c);
        }
    }

    public void adaugaComandaPentruClient(Client client, List<Produs> produse) {
        Comanda comanda = new Comanda(nextComandaId++, client, produse);
        comenziClient.get(client.getId()).add(comanda);
        System.out.println("Comanda adaugata: " + comanda.getId());
    }

    public List<Comanda> getComenziClient(Client client) {
        return comenziClient.getOrDefault(client.getId(), new ArrayList<>());
    }
}
