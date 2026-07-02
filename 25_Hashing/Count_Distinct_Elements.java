import java.util.HashSet;
public class Count_Distinct_Elements {
    public static int count_unique_elements(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for( int i = 0 ; i < nums.length ; i++ ) {
            hs.add(nums[i]);
        }

        return hs.size();
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 4, 3, 3, 5, 6, 7, 7};
        int unique_elements = count_unique_elements(nums);
        System.out.println(unique_elements);
    }
}
