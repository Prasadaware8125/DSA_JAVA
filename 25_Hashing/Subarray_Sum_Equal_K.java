import java.util.HashMap;

public class Subarray_Sum_Equal_K {
    // O(n^2)
    public static int brute_force(int[] arr, int k) {
        int count = 0;
        for( int i = 0 ; i < arr.length ; i++ ) {
            int sum = 0;
            for( int j = i ; j < arr.length ; j++ ) {
                sum += arr[j];
                if( sum == k ) {
                    count++;
                }
            }
        }
        return count;
    }
    // O(n)
    public static int subarray_sum_equal_k(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // sum, count
        map.put(0, 1);
        int sum = 0;
        int count = 0;

        for( int j = 0 ; j < arr.length ; j++ ) {
            sum += arr[j];
            if( map.containsKey(sum-k) ) {
                count += map.get(sum-k);
            } 
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        // int[] arr = {1, 2, 3};
        // int k = 3;
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        int res = subarray_sum_equal_k(arr, k);
        System.out.println("Number of subarray equal k => "+res);
    }
}
