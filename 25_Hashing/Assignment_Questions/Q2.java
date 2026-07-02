import java.util.HashMap;

// Two Sum
// Given an array of integers arr[ ]and an integer target, return indices of the two numbers such
// that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the
// same element twice.
// You can return the answer in any order.
// Sample Input 1 : arr = [2, 7, 11, 15], target = 9
// Sample Output 1 : [0, 1]
// As arr[0] + arr[1] == 9, we return [0, 1].
// Sample Input 2 : arr = [3,2,4], target = 6
// Sample Output 2 : [1, 2]

public class Q2 {
    // O(n)
    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for( int i = 0 ; i < arr.length ; i++ ) {
            int diff = target - arr[i];

            if( map.containsKey(diff) ) {
                return new int[] { map.get(diff), i};
            } 
            map.put(arr[i], i);
        }
        return new int[] {-1, -1};
    }
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(arr, target);
        for (int i : res) {
            System.out.println(i);
        }
    }
}

