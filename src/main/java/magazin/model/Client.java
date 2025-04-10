package model;

public class Client extends Persoana {
    private int id;

    public Client(int id, String nume, Adresa adresa) {
        super(nume, adresa);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nume='" + getNume() + '\'' + ", adresa=" + getAdresa() + '}';
    }
}
