package model;

public class Distribuitor {
    private String nume;
    private Adresa adresa;

    public Distribuitor(String nume, Adresa adresa) {
        this.nume = nume;
        this.adresa = adresa;
    }

    public String getNume() {
        return nume;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    @Override
    public String toString() {
        return nume + " (" + adresa + ")";
    }
}
