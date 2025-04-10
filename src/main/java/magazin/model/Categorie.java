package model;

public class Categorie {
    private String nume;

    public Categorie(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        return nume;
    }
}
