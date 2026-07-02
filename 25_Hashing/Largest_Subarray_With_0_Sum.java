import java.util.HashMap;

public class Largest_Subarray_With_0_Sum {
    public static int largest_subarray_with_0_sum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int len = 0;
        for( int i = 0 ; i < arr.length ; i++ ) {
            sum += arr[i];
            // If sum becomes 0
            if (sum == 0) {
                len = i + 1;
            }
            if( map.containsKey(sum) ) {
                len = Math.max( len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int res = largest_subarray_with_0_sum(arr);
        System.out.println(res);
    }
}