import java.util.ArrayList;
public class PairSum2 {

    public static ArrayList<Integer> pairSumR( ArrayList<Integer> list , int target ) {
        int breakPoint = -1;
        ArrayList<Integer> ans = new ArrayList<>();
        for( int i = 0 ; i < list.size() ; i++ ) {
            if( list.get(i) > list.get(i+1) ) {
                breakPoint = i;
                break;
            }
        }
        int lp = breakPoint+1;
        int rp = breakPoint;

        while( lp != rp ) {
            int sum = list.get(lp) + list.get(rp);
            if( sum == target) {
                ans.add(lp);
                ans.add(rp);
                return ans;
            } else if( sum < target ) {
                lp = ( lp + 1 ) % (list.size());
            } else {
                rp = ( list.size()+rp-1 ) % list.size();
            }
        }
        return ans;
    }
    public static void main(String []args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(pairSumR(list, 16));
        
    }
}
