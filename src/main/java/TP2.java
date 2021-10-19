import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TP2 {
    public static void main(String[] args) throws IOException {
        Path lien = Paths.get("C:/Users/brahi/OneDrive/Bureau/L3Info-Luminy/Algo2/TP2/dico.txt");
        List<String> dictionnaire = new ArrayList<>();
        dictionnaire = Files.readAllLines(lien);

        Scanner scanner = new Scanner(System.in);
        String mot = scanner.next();
        int distance;
        for (String motDictionnaire : dictionnaire){
            distance = Distance.distance(mot, motDictionnaire);
            System.out.println(distance);
        }


    }
}
