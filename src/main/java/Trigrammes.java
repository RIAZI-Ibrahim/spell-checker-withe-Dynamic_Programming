import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Trigrammes {
    private HashMap<String, LinkedList<String>> trigrammesPossibles = new LinkedHashMap<>();
    public Trigrammes(List<String> dictionnaire) {
        StringBuilder mot;
        HashMap<String, LinkedList<String>> listeMot = new HashMap<>();
        for (String motDictionnaire : dictionnaire) {
            mot = new StringBuilder(motDictionnaire);
            mot.insert(0, '<');
            mot.append('>');
            for (int i = 0; i < mot.length() - 2; i++) {
                if (!trigrammesPossibles.containsKey(mot.substring(i, i + 3))) {
                    trigrammesPossibles.put(mot.substring(i, i + 3), null);
                    listeMot.put(mot.substring(i, i + 3), new LinkedList<>());
                    listeMot.get(mot.substring(i, i + 3)).add(motDictionnaire);
                    trigrammesPossibles.put(mot.substring(i, i + 3), listeMot.get(mot.substring(i, i + 3)));
                }
                else {
                    listeMot.get(mot.substring(i, i + 3)).add(motDictionnaire);
                    trigrammesPossibles.put(mot.substring(i, i + 3), listeMot.get(mot.substring(i, i + 3)));
                }
            }
        }
        //System.out.println(trigrammesPossibles);
       /* for (String motDictionnaire : dictionnaire) {
            mot = new StringBuilder(motDictionnaire);
            mot.insert(0, '<');
            mot.append('>');
            for (int i = 0; i < mot.length() - 2; i++) {
                listeMot.get(mot.substring(i, i + 3)).add(motDictionnaire);
                trigrammesPossibles.put(mot.substring(i, i + 3), listeMot.get(mot.substring(i, i + 3)));
            }
        }*/
       // System.out.println(trigrammesPossibles);
        //System.out.println(trigrammesPossibles.get("<ab"));

    }
    public HashMap<String, String> trigrammeMot(String mot){
        HashMap<String, String> hashTrigrammesMot = new LinkedHashMap<>();
        StringBuilder motBuilder;
        motBuilder = new StringBuilder(mot);
        motBuilder.insert(0, '<');
        motBuilder.append('>');
        for (int i = 0; i < motBuilder.length() - 2; i++) {
            hashTrigrammesMot.put(motBuilder.substring(i, i + 3), "");
        }
        return hashTrigrammesMot;
    }

    public LinkedList<String> listeMotTrigrammesCommun (HashMap<String, String> trigrammes){
        LinkedList<String> motsTrigerammeCommun = new LinkedList<>();
        for (String trig : trigrammes.keySet()) {
            if (trigrammesPossibles.containsKey(trig)){
                motsTrigerammeCommun.addAll((Collection<? extends String>) trigrammesPossibles.get(trig).clone());
            }
        }
        return motsTrigerammeCommun;
    }
}

