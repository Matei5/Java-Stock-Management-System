package model;

public class Angajat extends Persoana {
    private String functie;

    public Angajat(String nume, Adresa adresa, String functie) {
        super(nume, adresa);
        this.functie = functie;
    }

    public String getFunctie() {
        return functie;
    }

    @Override
    public String toString() {
        return "Angajat{" + "nume='" + getNume() + '\'' + ", functie='" + functie + '\'' + ", adresa=" + getAdresa() + '}';
    }
}
