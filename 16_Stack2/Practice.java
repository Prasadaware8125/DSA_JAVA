import java.util.Stack;

public class Practice {
    public static int maxArea(int[] heights) {
        int n = heights.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];

        Stack<Integer> s = new Stack<>();

        // Nest Smaller Right
        for( int i = n-1 ; i >= 0 ; i-- ) {
            while( !s.isEmpty() && heights[s.peek()] >= heights[i] ) {
                s.pop();
            }
            if( s.isEmpty() ) {
                nsr[i] = n;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // Nest Smaller Left

        s = new Stack<>();
        for( int i = 0 ; i < n ; i++ ) {
            while ( !s.isEmpty() && heights[s.peek()] >= heights[i] ) {
                s.pop();
            }
            if( s.isEmpty() ) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        int maxArea = 0;

        for( int i = 0 ; i < n ; i++ ) {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(maxArea(heights));
    }
}
