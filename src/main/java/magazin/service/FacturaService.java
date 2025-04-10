package service;

import java.util.Scanner;
import model.*;

public class FacturaService {
    private int nextFacturaId = 1;

    public void genereazaFactura(Scanner input, ClientService clientService) {
        if (input == null || clientService == null) {
            throw new IllegalArgumentException("Input and ClientService cannot be null");
        }

        Client client = clientService.cautaClientDupaId(input);
        if (client == null) return;

        var comenzi = clientService.getComenziClient(client);
        if (comenzi.isEmpty()) {
            System.out.println("Clientul nu are comenzi.");
            return;
        }

        System.out.print("ID comanda: ");
        int idComanda = input.nextInt();
        input.nextLine();

        for (Comanda c : comenzi) {
            if (c.getId() == idComanda) {
                Factura factura = new Factura(nextFacturaId++, c);
                System.out.println("Factura generata:\n" + factura);
                return;
            }
        }

        System.out.println("Comanda inexistenta.");
    }
}
