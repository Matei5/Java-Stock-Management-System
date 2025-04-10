package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Adresa;
import model.Distribuitor;

public class DistribuitorService {
    private final List<Distribuitor> distribuitori = new ArrayList<>();
    private final AdresaService adresaService;

    public DistribuitorService(AdresaService adresaService) {
        this.adresaService = adresaService;
    }

    public void adaugaDistribuitor(Scanner input) {
        System.out.print("Nume distribuitor: ");
        String nume = input.nextLine();

        System.out.println("Introduceti adresa distribuitorului:");
        Adresa adresa = adresaService.creeazaAdresa(input);

        Distribuitor d = new Distribuitor(nume, adresa);
        distribuitori.add(d);

        System.out.println("Distribuitor adaugat.");
    }

    public void afiseazaDistribuitori() {
        if (distribuitori.isEmpty()) {
            System.out.println("Nu exista distribuitori.");
            return;
        }

        for (Distribuitor d : distribuitori) {
            System.out.println(d);
        }
    }
}
