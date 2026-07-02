import java.util.ArrayList;
import java.util.Scanner;
public class Q1 {
// Monotonic ArrayList(Easy)
    public static boolean isMonotonic( ArrayList<Integer> list ) {
        boolean inc = true, dec = true;
        for( int i = 0 ; i < list.size()-1 ; i++ ) {
            if( list.get(i) > list.get(i+1)) {
                inc = false;
            }
            if( list.get(i) < list.get(i+1)) {
                dec = false;
            }
        }

        return inc || dec;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of list : ");
        int n = sc.nextInt();
        for( int i = 0 ; i < n ; i++ ) {
            System.out.print("Enter number : ");
            int num = sc.nextInt();
            list.add(num);
        }
        System.out.println(isMonotonic(list));
        sc.close();
    }
}
