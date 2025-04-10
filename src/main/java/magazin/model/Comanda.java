package model;

import java.util.List;

public class Comanda {
    private int id;
    private Client client;
    private List<Produs> produse;

    public Comanda(int id, Client client, List<Produs> produse) {
        this.id = id;
        this.client = client;
        this.produse = produse;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    @Override
    public String toString() {
        return "Comanda{" + "id=" + id + ", client=" + client.getNume() + ", produse=" + produse + '}';
    }
}
