import com.example.tp2.Trigrammes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TP2 {
    public static void main(String[] args) throws IOException {
        Path lien = Paths.get("C:/Users/brahi/OneDrive/Bureau/L3Info-Luminy/Algo2/TP2/minidico.txt");
        List<String> dictionnaire = new ArrayList<>();
        dictionnaire = Files.readAllLines(lien);

        /*Scanner scanner = new Scanner(System.in);
        String mot = scanner.next();
        for (String motDictionnaire : dictionnaire){
            System.out.println("La distansce est : "+DistanceDynamic.distance("Chine", motDictionnaire));
        }*/
        // System.out.println("La distansce est : "+DistanceDynamic.distance("Chine", "Chien"));

         System.out.println("La distansce est : "+DistanceDynamic.distance("Chine", "Chien"));


        Trigrammes t = new Trigrammes(dictionnaire);
        HashMap<String, String> tr = new LinkedHashMap<>();
        List<String> l = new ArrayList<>();
        tr = t.trigrammeMot("abatt");
        l = t.listeMotTrigrammesCommun(tr);
        System.out.println(l);
        System.out.println(t.nbOccurance(l));
        System.out.println(System.nanoTime());
    }
}
