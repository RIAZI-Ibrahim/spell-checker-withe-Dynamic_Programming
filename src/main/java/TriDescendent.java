import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TriDescendent implements Comparator {
    Map maList;

    public TriDescendent(Map maList) {
        this.maList = maList;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if ((Long) maList.get(o1) >= (Long) maList.get(o2)) {
            return -1;
        } else {
            return 1;
        }
    }
}
