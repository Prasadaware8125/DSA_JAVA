import java.util.HashMap;

public class HashMap_Operations {
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert: O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        // Printing whole HashMap
        System.out.println(hm);

        // Get: O(1)
        int population = hm.get("India");
        System.out.println(population);

        // ContainsKey: O(1)
        boolean isKey = hm.containsKey("India");
        System.out.println(isKey);

        // Remove: O(1)
        int removedPopulation = hm.remove("China");
        System.out.println(removedPopulation);
        
        System.out.println(hm);

        // Size:
        int size = hm.size();
        System.out.println(size);

        // isEmpry:
        System.out.println(hm.isEmpty());

        // Clear:
        hm.clear();
        System.out.println(hm);
    }
}
