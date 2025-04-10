package service;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class PersoanaService {
    private final List<Persoana> persoane = new ArrayList<>();

    public void adaugaPersoana(Persoana persoana) {
        persoane.add(persoana);
    }

    public void afiseazaToatePersoanele() {
        if (persoane.isEmpty()) {
            System.out.println("Nu exista persoane inregistrate.");
            return;
        }

        for (Persoana p : persoane) {
            System.out.println(p);
        }
    }

    public void afiseazaNumaiClienti() {
        for (Persoana p : persoane) {
            if (p instanceof Client) {
                System.out.println(p);
            }
        }
    }

    public void afiseazaNumaiAngajati() {
        for (Persoana p : persoane) {
            if (p instanceof Angajat) {
                System.out.println(p);
            }
        }
    }

    public List<Persoana> getPersoane() {
        return persoane;
    }
}
