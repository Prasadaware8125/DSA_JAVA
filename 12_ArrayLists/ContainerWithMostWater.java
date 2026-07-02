import java.util.ArrayList;
public class ContainerWithMostWater {
    // Brute Force 
    // Time Complexity = O(n^2)
    public static int maxWater( ArrayList<Integer> height) {
        int maxWater = 0;
        for( int i = 0 ; i < height.size() ; i++ ) {
            for( int j = i+1 ; j < height.size() ; j++ ) {
                int h = Math.min(height.get(i),height.get(j));
                int width = j-i;
                int currWater = h * width;
                maxWater = Math.max( maxWater , currWater );
            }
        }
        return maxWater;
    }

    // Two Pointer Approach
    // Time Complexity = O(n)

    public static int max( ArrayList<Integer> height ) {
        int maxWater = 0;
        int start = 0, end = height.size()-1;
        while ( start <= end ) {
            int h = Math.min( height.get(start), height.get(end) );
            int width = end-start;
            int currWater = h * width;
            maxWater = Math.max( maxWater, currWater);
            if( height.get(start) < height.get(end) ) {
                start++;
            } else {
                end--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        // System.out.println(maxWater(height));
        System.out.println(max(height));
    }
}
