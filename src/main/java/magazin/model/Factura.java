package model;

public class Factura {
    private int id;
    private Comanda comanda;
    private double total;

    public Factura(int id, Comanda comanda) {
        this.id = id;
        this.comanda = comanda;
        this.total = calculeazaTotal();
    }

    private double calculeazaTotal() {
        return comanda.getProduse().stream()
                .mapToDouble(p -> p.getPret() * p.getCantitate())
                .sum();
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", comanda=" + comanda.getId() + ", total=" + total + '}';
    }
}
