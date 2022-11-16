import java.util.Comparator;
import java.util.Map;

public class TriAscendant implements Comparator {
    Map maList;

    public TriAscendant(Map maList) {
        this.maList = maList;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if ((Long) maList.get(o1) <= (Long) maList.get(o2)) {
            return -1;
        } else {
            return 1;
        }
    }
}

