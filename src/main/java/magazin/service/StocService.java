package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;

public class StocService {
    private final List<Stoc> stocuri = new ArrayList<>();

    public void adaugaStoc(Scanner input, List<Produs> produse) {
        System.out.print("ID produs: ");
        int id = input.nextInt();
        input.nextLine();

        Produs produs = null;
        for (Produs p : produse) {
            if (p.getId() == id) {
                produs = p;
                break;
            }
        }

        if (produs == null) {
            System.out.println("Produs inexistent.");
            return;
        }

        System.out.print("Cantitate disponibila: ");
        int cantitate = input.nextInt();
        input.nextLine();

        stocuri.add(new Stoc(produs, cantitate));
        System.out.println("Stoc adaugat.");
    }

    public void afiseazaStocuri() {
        if (stocuri.isEmpty()) {
            System.out.println("Nu exista stocuri.");
            return;
        }

        for (Stoc s : stocuri) {
            System.out.println(s);
        }
    }
}
