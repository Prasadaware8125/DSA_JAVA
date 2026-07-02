import java.util.ArrayList;
import java.util.Scanner;
public class Q2 {

    public static ArrayList<Integer> isLonely( ArrayList<Integer> list ) {
        ArrayList<Integer> ans = new ArrayList<>();
        for( int i = 1 ; i < list.size()-1 ; i++ ) {
            int curr = list.get(i);
            int prev = list.get(i-1);
            int next = list.get(i+1);
            if( (prev+1) < curr && (curr+1) < next ) {
                ans.add(curr);
            }
        }

        if( list.size() == 1 ) {
            ans.add(list.get(0));
        }

        if( list.size() > 1 ) {
            if( list.get(0) + 1 != list.get(1) ) {
                ans.add(list.get(0));
            }
            if( list.get(list.size()-2 ) + 1 < list.get(list.size() - 1 )) {
                ans.add(list.get(list.size() - 1 ));
            }
        }
        return ans;
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

        System.out.println(isLonely(list));
        sc.close();
    }
}
