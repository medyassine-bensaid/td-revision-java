import java.util.*;

public class Agence implements LocationInterface {

    private String nom;
    private ListVoitures listVoitures;
    private Map<Client, ListVoitures> clientVoiturMap;

    public Agence(String nom, ListVoitures listVoitures, Map<Client, ListVoitures> clientVoiturMap) {
        this.nom = nom;
        this.listVoitures = listVoitures;
        this.clientVoiturMap = clientVoiturMap;
    }

    @Override
    public void louerVoiture(Client client, Voiture voiture) {
        if (clientVoiturMap.containsKey(client)){
            clientVoiturMap.get(client).addVoiture(voiture);
        }
    }

    @Override
    public void retournerVoiture(Client client) {
        if (clientVoiturMap.containsKey(client)){
            clientVoiturMap.get(client).displayVoitures();
        }
    }

    @Override
    public void voituresSelonCritere(Critere critere , Voiture voiture , ListVoitures listVoitures)  {

        if (clientVoiturMap.containsValue(listVoitures)){
            if (critere.estSatisfaitPar(voiture)){
                listVoitures.displayVoitures();
            }
        }


    }

    @Override
    public Set<Client> clientsQuiOntLoue() {

        return clientVoiturMap.keySet();
    }

    @Override
    public Collection<ListVoitures> voituresEnLocation() {
        return  clientVoiturMap.values();
    }

    @Override
    public void afficherClientsEtVoituresLouees() {
        for ( Map.Entry<Client,ListVoitures>  entry: clientVoiturMap.entrySet()) {
            Client client = entry.getKey();
            ListVoitures listVoitures = entry.getValue();
            System.out.println("Clé : " + client + ", Valeur : " + listVoitures);
        }
    }


    public Map<Client, ListVoitures> trierParNomClient() {

        Map<Client, ListVoitures> sortedMap = new TreeMap<>(new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                return c1.getNom().compareTo(c2.getNom());
            }
        });

        sortedMap.putAll(clientVoiturMap);
        return sortedMap;
    }
    public Map<Client, ListVoitures> trierParCodeClient() {

        Map<Client, ListVoitures> sortedMap = new TreeMap<>();


        sortedMap.putAll(clientVoiturMap);
        return sortedMap;
    }
}
