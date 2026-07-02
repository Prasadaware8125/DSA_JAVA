import java.util.*;
// We are given an infinite supply of denominations [1, 2, 5, 10, 20, 50, 100, 500, 2000].
// Find min no. of coins/ notes to make change for a value V.

// Eg. V = 121
// ans = 3 (100 + 20 + 1)

// Eg. V = 590
// ans = 4 (500 + 50 + 20 + 20)
public class Indian_Coins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value V = ");
        int V = sc.nextInt();

        Integer coins[] = {2000, 500, 100, 50, 20, 10, 5, 2 ,1};
        Arrays.sort(coins, Comparator.reverseOrder());

        int countOfCoints = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for( int i = 0 ; i < coins.length ; i++ ) {
            if( coins[i] <= V ) {
                while( coins[i] <= V ) {
                    countOfCoints++;
                    ans.add(coins[i]);
                    V -= coins[i];
                }
            }
        }

        System.out.println("Total min coints used = "+ countOfCoints);
        for( int i = 0 ; i < ans.size() ; i++ ) {
            System.out.print(ans.get(i)+" ");
        }
        sc.close();
    }
}