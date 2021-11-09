import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Correcteur {
    static Map<String, Long> nbOccurance (LinkedList<String> mots){
        Map<String, Long> listeMots = new LinkedHashMap<>();
        listeMots = mots.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return listeMots;
    }

    static TreeMap<String, Long> motsTriés (Map<String, Long> mots){
        TriDescendant comparateur =  new TriDescendant(mots);
        TreeMap motsTriés = new TreeMap(comparateur);
        motsTriés.putAll(mots);
        return motsTriés;
    }

    static LinkedHashMap<String, Long> motsSéléctionés (TreeMap<String, Long> mots){
        LinkedHashMap<String, Long> mesMots = new LinkedHashMap();
        int i = 0;
        for (String key : mots.keySet()){
            if (i > 100) break;
            mesMots.put(key, 0L);
            i++;
        }
        return mesMots;
    }
    static TreeMap<String, Long> motsProches (LinkedHashMap<String,Long> mots, String motAcourriger){
        TriAscendant comparateur =  new TriAscendant(mots);
        TreeMap motsProches = new TreeMap(comparateur);
        for (String key : mots.keySet()){
            mots.put(key, DistanceDynamic.distance(key, motAcourriger));
        }
        motsProches.putAll(mots);
        return motsProches;
    }
    static LinkedList<String> motsAchoisir (TreeMap<String, Long> mots){
        LinkedList<String> mesMots = new LinkedList<String>();
        int i = 0;
        for (String key : mots.keySet()){
            if (i >= 5) break;
            mesMots.add(key);
            i++;
        }
        return mesMots;
    }
}
