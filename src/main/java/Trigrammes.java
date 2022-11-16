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
                } else {
                    listeMot.get(mot.substring(i, i + 3)).add(motDictionnaire);
                    trigrammesPossibles.put(mot.substring(i, i + 3), listeMot.get(mot.substring(i, i + 3)));
                }
            }
        }
    }

    public List<String> trigrammeMot(String mot) {
        List<String> hashTrigrammesMot = new ArrayList<>();
        StringBuilder motBuilder;
        motBuilder = new StringBuilder(mot);
        motBuilder.insert(0, '<');
        motBuilder.append('>');
        for (int i = 0; i < motBuilder.length() - 2; i++) {
            hashTrigrammesMot.add(motBuilder.substring(i, i + 3));
        }
        return hashTrigrammesMot;
    }

    public LinkedList<String> listeMotTrigrammesCommun(List<String> trigrammes) {
        LinkedList<String> motsTrigerammeCommun = new LinkedList<>();
        for (String trig : trigrammes) {
            if (trigrammesPossibles.containsKey(trig)) {
                motsTrigerammeCommun.addAll((Collection<? extends String>) trigrammesPossibles.get(trig).clone());
            }
        }
        return motsTrigerammeCommun;
    }
}

