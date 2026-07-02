import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMaps {
    public static void main(String[] args) {
        // It stores the keys in the input sequence
        // Input order = output order
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);

        // It stores the keys randomly
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println("HashMap");
        System.out.println(hm);
        System.out.println("LinkedHashMap");
        System.out.println(lhm);
    }
}
