import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Correcteur {
    static Map<String, Long> nbOccurrence(LinkedList<String> mots) {
        Map<String, Long> listeMots = new LinkedHashMap<>();
        listeMots = mots.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return listeMots;
    }

    static TreeMap<String, Long> motsTriés(Map<String, Long> mots) {
        TriDescendent comparateur = new TriDescendent(mots);
        TreeMap motsTriés = new TreeMap(comparateur);
        motsTriés.putAll(mots);
        return motsTriés;
    }

    static LinkedHashMap<String, Long> motsSéléctionnés(TreeMap<String, Long> mots) {
        LinkedHashMap<String, Long> mesMots = new LinkedHashMap();
        int i = 0;
        for (String key : mots.keySet()) {
            if (i > 100) break;
            mesMots.put(key, 0L);
            i++;
        }
        return mesMots;
    }

    static TreeMap<String, Long> motsProches(LinkedHashMap<String, Long> mots, String motAcourriger) {
        TriAscendant comparateur = new TriAscendant(mots);
        TreeMap motsProches = new TreeMap(comparateur);
        for (String key : mots.keySet()) {
            mots.put(key, DistanceLevenshtein.distance(key, motAcourriger));
        }
        motsProches.putAll(mots);
        return motsProches;
    }

    static List<String> motsAchoisir(TreeMap<String, Long> mots) {
        List<String> mesMots = new ArrayList<String>();
        int i = 0;
        for (String key : mots.keySet()) {
            if (i >= 5) break;
            mesMots.add(key);
            i++;
        }
        return mesMots;
    }
}
