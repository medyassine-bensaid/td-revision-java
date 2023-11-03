import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface LocationInterface {
    void louerVoiture(Client client, Voiture voiture);
    void retournerVoiture(Client client);
    void voituresSelonCritere(Critere critere , Voiture voiture , ListVoitures listVoitures);
    Set<Client> clientsQuiOntLoue();
    Collection<ListVoitures> voituresEnLocation();
    void afficherClientsEtVoituresLouees();
}
