package model;

public class Stoc {
    private Produs produs;
    private int cantitateDisponibila;

    public Stoc(Produs produs, int cantitateDisponibila) {
        this.produs = produs;
        this.cantitateDisponibila = cantitateDisponibila;
    }

    public Produs getProdus() {
        return produs;
    }

    public int getCantitateDisponibila() {
        return cantitateDisponibila;
    }

    public void setCantitateDisponibila(int cantitateDisponibila) {
        this.cantitateDisponibila = cantitateDisponibila;
    }

    @Override
    public String toString() {
        return "Stoc{" + "produs=" + produs + ", cantitateDisponibila=" + cantitateDisponibila + '}';
    }
}
