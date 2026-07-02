import java.util.HashSet;
import java.util.Iterator;
public class HashSet_Iteration {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Mumbail");
        cities.add("Delhi");
        cities.add("Pune");
        cities.add("Bengalore");
        cities.add("Hydrabad");

        // Using Iterator
        Iterator it = cities.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();

        // Advance Loops
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
