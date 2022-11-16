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
        Path lienFautes = Paths.get("src/fautes.txt");
        List<String> fautes = new ArrayList<>();
        fautes = Files.readAllLines(lienFautes);
        Trigrammes phaseTrigramme = new Trigrammes(dictionnaire);
        List<String> trigrammes = new ArrayList<>();
        LinkedList<String> listeTrigrammesCommuns = new LinkedList<String>();
        Map<String, Long> listeNbOccurrence = new LinkedHashMap<>();
        LinkedHashMap<String, Long> listeMotsSéléctionnés = new LinkedHashMap<>();
        TreeMap<String, Long> listeMotsProches = new TreeMap<>();
        List<String> motsAchoisir = new ArrayList<>();
        for (String motFaux : fautes) {
            if (dictionnaire.contains(motFaux)) System.out.println("Le mot est correcte.");
            else {
                trigrammes = phaseTrigramme.trigrammeMot(motFaux);
                listeTrigrammesCommuns = phaseTrigramme.listeMotTrigrammesCommun(trigrammes);
                listeNbOccurrence = Correcteur.nbOccurrence(listeTrigrammesCommuns);
                listeNbOccurrence = Correcteur.motsTriés(listeNbOccurrence);
                listeMotsSéléctionnés = Correcteur.motsSéléctionnés((TreeMap<String, Long>) listeNbOccurrence);
                listeMotsProches = Correcteur.motsProches(listeMotsSéléctionnés, motFaux);
                motsAchoisir = Correcteur.motsAchoisir(listeMotsProches);
                System.out.println(motFaux + " ==> " + motsAchoisir);
            }
        }

        tempsFin = System.nanoTime();
        seconds = (tempsFin - tempsDebut) / 1000000000F;
        System.out.println("Opération effectuée en: " + Double.toString(seconds) + " secondes.");

    }
}
