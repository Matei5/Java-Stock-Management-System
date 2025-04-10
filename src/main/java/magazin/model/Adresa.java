package model;

public class Adresa {
    private String oras;
    private String strada;
    private int numar;

    public Adresa(String oras, String strada, int numar) {
        this.oras = oras;
        this.strada = strada;
        this.numar = numar;
    }

    @Override
    public String toString() {
        return oras + ", " + strada + " nr. " + numar;
    }
}
