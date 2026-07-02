import java.util.ArrayList;
import java.util.Scanner;
// Most Frequent Number following Key(EASY)
public class Q3 {

    static int countTarget( ArrayList<Integer> list , int key ) {
        int freq[] = new int[1001];
        for( int i = 0 ; i < list.size() ; i++ ) {
            if( list.get(i) == key ) {
                int target = list.get(i+1);
                freq[target]++;
            }
        }
        int target = 0 , maxValue = 0;;
        for( int i = 0 ; i < freq.length ; i++ ) {
            if( maxValue < freq[i] ) {
                target = i;
                maxValue = freq[i];
            }
        }
        return target;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of list : ");
        int n = sc.nextInt();
        System.out.print("Enter Key : ");
        int key = sc.nextInt();
        for( int i = 0 ; i < n ; i++ ) {
            System.out.print("Enter number : ");
            int num = sc.nextInt();
            list.add(num);
        }
        System.out.println(countTarget(list, key));
        sc.close();
    }
}
