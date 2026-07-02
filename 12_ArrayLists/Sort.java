import java.util.ArrayList;
import java.util.Collections;
public class Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(19);
        list.add(3);
        list.add(9);
        list.add(5);
        list.add(8);
        list.add(11);

        System.out.println(list);
        Collections.sort(list); // In Ascending Order
        System.out.println(list);

        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
    }
}
