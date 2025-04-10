package model;

public class Produs {
    private int id;
    private String nume;
    private double pret;
    private int cantitate;
    private Categorie categorie;
    private Distribuitor distribuitor;

    public Produs(int id, String nume, double pret, int cantitate, Categorie categorie, Distribuitor distribuitor) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.categorie = categorie;
        this.distribuitor = distribuitor;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public double getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Distribuitor getDistribuitor() {
        return distribuitor;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return "Produs{" + "id=" + id + ", nume='" + nume + '\'' + ", pret=" + pret + ", cantitate=" + cantitate + ", categorie=" + categorie + ", distribuitor=" + distribuitor + '}';
    }
}
