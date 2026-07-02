import java.util.ArrayList;
public class PairSum1 {

    // Brute Force Approach
    // Time Complexity = O(n^2)
    public static boolean pairSumB( ArrayList<Integer> list , int target ) {
        for( int i = 0 ; i < list.size() ; i++ ) {
            for( int j = i+1 ; j < list.size() ; j++ ) {
                if( (list.get(i) + list.get(j)) == target ) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean pairSumT( ArrayList<Integer> list , int target ) {
        int lp = 0, rp = list.size()-1;
        while (lp <= rp ) {
            int sum = list.get(lp) + list.get(rp);
            if( sum == target ) {
                return true;
            } else if( sum < target ) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;

        // System.out.println(pairSumB(list, target));
        System.out.println(pairSumT(list, target));
    }
}
