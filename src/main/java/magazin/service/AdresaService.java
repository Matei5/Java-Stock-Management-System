package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Adresa;

public class AdresaService {
    private final List<Adresa> adrese = new ArrayList<>();

    public Adresa creeazaAdresa(Scanner input) {
        System.out.print("Oras: ");
        String oras = input.nextLine();

        System.out.print("Strada: ");
        String strada = input.nextLine();

        System.out.print("Numar: ");
        int numar = input.nextInt();
        input.nextLine();

        Adresa adresa = new Adresa(oras, strada, numar);
        adrese.add(adresa);
        return adresa;
    }

    public void afiseazaAdrese() {
        if (adrese.isEmpty()) {
            System.out.println("Nu exista adrese salvate.");
            return;
        }

        for (Adresa a : adrese) {
            System.out.println(a);
        }
    }
}
