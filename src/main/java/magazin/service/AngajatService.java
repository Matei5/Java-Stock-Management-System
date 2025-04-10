package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Adresa;
import model.Angajat;

public class AngajatService {
    private final List<Angajat> angajati = new ArrayList<>();
    private final AdresaService adresaService;

    public AngajatService(AdresaService adresaService) {
        this.adresaService = adresaService;
    }

    public void adaugaAngajat(Scanner input) {
        System.out.print("Nume angajat: ");
        String nume = input.nextLine();

        System.out.print("Functie: ");
        String functie = input.nextLine();

        System.out.println("Introduceti adresa angajatului:");
        Adresa adresa = adresaService.creeazaAdresa(input);

        Angajat angajat = new Angajat(nume, adresa, functie);
        angajati.add(angajat);

        System.out.println("Angajat adaugat.");
    }

    public void afiseazaAngajati() {
        if (angajati.isEmpty()) {
            System.out.println("Nu exista angajati.");
            return;
        }

        for (Angajat a : angajati) {
            System.out.println(a);
        }
    }
}
