package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Categorie;

public class CategorieService {
    private final List<Categorie> categorii = new ArrayList<>();

    public Categorie adaugaCategorie(Scanner input) {
        System.out.print("Nume categorie: ");
        String nume = input.nextLine();

        Categorie categorie = new Categorie(nume);
        categorii.add(categorie);
        System.out.println("Categorie adaugata.");
        return categorie;
    }

    public void afiseazaCategorii() {
        if (categorii.isEmpty()) {
            System.out.println("Nu exista categorii.");
            return;
        }

        for (Categorie c : categorii) {
            System.out.println(c);
        }
    }

    public Categorie cautaCategorieDupaNume(String nume) {
        for (Categorie c : categorii) {
            if (c.getNume().equalsIgnoreCase(nume)) {
                return c;
            }
        }
        return null;
    }

    public List<Categorie> getCategorii() {
        return categorii;
    }
}
