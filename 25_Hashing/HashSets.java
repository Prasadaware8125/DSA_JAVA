import java.util.HashSet;
public class HashSets {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(4);
        hs.add(0);
        hs.add(1);
        hs.add(5);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(0);
        System.out.println(hs);
        System.out.println(hs.contains(4));
        System.out.println(hs.remove(4));
        System.out.println(hs.size());
    }
}
