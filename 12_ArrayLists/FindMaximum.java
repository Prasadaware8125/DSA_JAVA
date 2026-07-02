import java.util.ArrayList;
public class FindMaximum {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for( int i = 0 ; i < 10 ; i++  ) {
            list.add(i+1);
        }

        list.add( 7,99);

        int max = Integer.MIN_VALUE;
        for( int j = 0 ; j < list.size() ; j++ ) {
            max = Math.max( max , list.get(j));
        }

        System.out.println("Maximum number = "+ max);
    }
}
