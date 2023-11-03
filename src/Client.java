import java.util.Comparator;
import java.util.Objects;

public class Client implements Comparable<Client> , Comparator<Client> {
    private int code;
    private String nom;
    private String prenom;

    public Client(int code, String nom, String prenom) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, nom, prenom);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Client otherClient = (Client) obj;
        return code == otherClient.code &&
                Objects.equals(nom, otherClient.nom) &&
                Objects.equals(prenom, otherClient.prenom);
    }

    @Override
    public String toString() {
        return "Client{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    @Override
    public int compareTo(Client client) {
        return this.code-client.code;
    }

    @Override
    public int compare(Client c1, Client c2) {
        return c1.getNom().compareTo(c2.getNom());
    }

}
