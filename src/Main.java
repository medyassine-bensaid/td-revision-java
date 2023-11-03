import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ListVoitures parking = new ListVoitures();
        Map<Client, ListVoitures> clientVoiturMap = new HashMap<>();
        Agence agence = new Agence("Your Agency", parking, clientVoiturMap);


        Client client1 = new Client(1, "John", "Doe");
        Client client2 = new Client(2, "Alice", "Smith");
        Voiture car1 = new Voiture(101, "Toyota", 50.0f);
        Voiture car2 = new Voiture(102, "Honda", 45.0f);

        agence.louerVoiture(client1, car1);
        agence.louerVoiture(client2, car2);


        System.out.println("Cars rented by clients:");
        agence.retournerVoiture(client1);


        Critere critere = new CritereMarque("Toyota");
        System.out.println("Cars based on the criteria:");
        agence.voituresSelonCritere(critere, car1, parking);


        System.out.println("Clients who have rented cars:");
        Set<Client> clients = agence.clientsQuiOntLoue();
        for (Client client : clients) {
            System.out.println(client);
        }


        System.out.println("Cars in rental state:");
        Collection<ListVoitures> carsInRental = agence.voituresEnLocation();
        System.out.println(carsInRental);

        // Display clients and their rented cars
        System.out.println("Clients and their rented cars:");
        agence.afficherClientsEtVoituresLouees();

        // Sort the client list by name
        Map<Client, ListVoitures> sortedByName = agence.trierParNomClient();
        System.out.println("Clients sorted by name:");
        for (Map.Entry<Client, ListVoitures> entry : sortedByName.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Sort the client list by code
        Map<Client, ListVoitures> sortedByCode = agence.trierParCodeClient();
        System.out.println("Clients sorted by code:");
        for (Map.Entry<Client, ListVoitures> entry : sortedByCode.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}