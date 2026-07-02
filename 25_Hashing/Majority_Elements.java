// Given an integer array of size n, find all 
// elements that appear more than (n/3) times.

// TC = O(n)
// SC = O(n)

import java.util.HashMap;
public class Majority_Elements {
    public static void printMajorityElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for( int num : nums ) {
            map.put( num, map.getOrDefault(num, 0) + 1);
        }

        for( int key : map.keySet() ) {
            if( map.get(key) >= nums.length/3 ) {
                System.out.print(key+" ");
            }
        }
    }
    public static void main(String[] args) {
        // int[] nums = { 1, 3, 2, 5, 1, 3, 1, 5, 1};
        int[] nums = { 1, 2};
        printMajorityElements(nums);
    }
}
