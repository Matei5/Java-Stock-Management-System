package service;

import java.util.*;
import model.*;

public class ComandaService {
    private final List<Comanda> comenzi = new ArrayList<>();
    private int nextComandaId = 1;

    public Comanda creeazaComanda(Client client, List<Produs> produse) {
        Comanda comanda = new Comanda(nextComandaId++, client, produse);
        comenzi.add(comanda);
        System.out.println("Comanda creata: ID " + comanda.getId());
        return comanda;
    }

    public void afiseazaToateComenzile() {
        if (comenzi.isEmpty()) {
            System.out.println("Nu exista comenzi.");
            return;
        }

        for (Comanda c : comenzi) {
            System.out.println(c);
        }
    }

    public Comanda getComandaDupaId(int id) {
        for (Comanda c : comenzi) {
            if (c.getId() == id) return c;
        }
        return null;
    }
}
