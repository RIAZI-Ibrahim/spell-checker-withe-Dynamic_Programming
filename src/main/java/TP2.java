import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TP2 {
    public static void main(String[] args) throws IOException {
        long tempsDebut, tempsFin;
        double seconds;
        tempsDebut = System.nanoTime();
        Path lien = Paths.get("src/dico.txt");
        List<String> dictionnaire = new ArrayList<>();
        dictionnaire = Files.readAllLines(lien);
         //System.out.println("La distansce est : "+DistanceDynamic.distance("Chine", "Chien"));

         //System.out.println("La distansce est : "+ DistanceDynamic.distance("abc", "cba"));

        Trigrammes phaseTrigramme = new Trigrammes(dictionnaire);
        HashMap<String, String> trigrammes = new HashMap<String, String>();
        LinkedList<String> listeTrigrammesCommuns = new LinkedList<String>();
        Path lienFautes = Paths.get("src/fautes.txt");
        List<String> fautes = new ArrayList<>();
        fautes = Files.readAllLines(lienFautes);
        int i = 1 ;
        Map<String, Long> listeNbOccurance = new LinkedHashMap<>();
        LinkedHashMap<String, Long> listeMotsSéléctionés = new LinkedHashMap<>();
        TreeMap<String, Long> listeMotsProches = new TreeMap<>();
        LinkedList<String> motsAchoisir = new LinkedList<>();
        for (String motFeaux : fautes) {
            if (dictionnaire.contains(motFeaux)) System.out.println("Le mot est correcte.");
            else {
                trigrammes = phaseTrigramme.trigrammeMot(motFeaux);
                listeTrigrammesCommuns = phaseTrigramme.listeMotTrigrammesCommun(trigrammes);
                listeNbOccurance = Correcteur.nbOccurance(listeTrigrammesCommuns);
                listeNbOccurance = Correcteur.motsTriés(listeNbOccurance);
                listeMotsSéléctionés = Correcteur.motsSéléctionés((TreeMap<String, Long>) listeNbOccurance);
                listeMotsProches = Correcteur.motsProches(listeMotsSéléctionés, motFeaux);
                motsAchoisir = Correcteur.motsAchoisir(listeMotsProches);
                System.out.println(motFeaux+" ==> "+motsAchoisir);
            }
      }

        tempsFin = System.nanoTime();
        seconds = (tempsFin - tempsDebut) / 1000000000F;
        System.out.println("Opération effectuée en: "+ Double.toString(seconds) + " secondes.");

    }
}
