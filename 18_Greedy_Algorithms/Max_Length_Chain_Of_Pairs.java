import java.util.*;

// TC = O(nlogn)
public class Max_Length_Chain_Of_Pairs {

    public static void main(String[] args) {
        int pairs[][] = {
            {5, 24},
            {39, 60},
            {5, 28},
            {27, 40},
            {50, 90}
        };

        // Sorting 2D array based on end of pairs
        // (a, b) then sorting based on b 
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        // for( int i = 0 ; i < pairs.length ; i++ ) {
        //     System.out.println("( "+pairs[i][0]+", "+pairs[i][1]+" )");
        // }

        int chainLen = 1;
        int chainEnd = pairs[0][1];
             // Last selected pair end or chain end
        System.out.println("Pair is ("+pairs[0][0]+", "+pairs[0][1]+")");

        for( int i = 1 ; i < pairs.length ; i++ ) {
            if( pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
                System.out.println("Pair is ("+pairs[i][0]+", "+pairs[i][1]+")");
            }
        }

        System.out.println("Max Length of chain = "+ chainLen);
    }
}