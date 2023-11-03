import java.util.ArrayList;
import java.util.List;

public class ListVoitures implements Crud {
    private List<Voiture> voitureList;

    public ListVoitures() {
        voitureList = new ArrayList<>();
    }

    public void addVoiture(Voiture voiture) {
        voitureList.add(voiture);
    }

    public void removeVoiture(Voiture voiture) {
        voitureList.remove(voiture);
    }


    public void displayVoitures() {
        System.out.println("List of Cars:");
        for (Voiture voiture : voitureList) {
            System.out.println(voiture);
        }
    }

}
