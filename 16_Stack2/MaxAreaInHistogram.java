import java.util.Stack;
// Microsoft, paytm & google question
// Time Complexity = O(n)
public class MaxAreaInHistogram {

    public static void maxArea( int arr[] ) {
        int n = arr.length;
        int nsl[] = new int[n];
        int nsr[] = new int[n];
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();
        
        // Next smaller right
        for( int i = n-1 ; i >= 0 ; i-- ) {
            while ( !stack.isEmpty() && arr[stack.peek()] >= arr[i] ) {
                stack.pop();
            }
            if( stack.isEmpty() ) {
                nsr[i] = n;
            } else {
                nsr[i] = stack.peek();
            }
            stack.push(i);
        }

        // Next smaller left
        stack = new Stack<>();

        for( int i = 0 ; i < n ; i++ ) {
            while ( !stack.isEmpty() && arr[stack.peek()] >= arr[i] ) {
                stack.pop();
            }
            if( stack.isEmpty() ) {
                nsl[i] = -1;
            } else {
                nsl[i] = stack.peek();
            }
            stack.push(i);  
        }

        // Calculating area
        // Width = j-i-1 : nsr[i] - nsl[i] - 1
        for( int i = 0 ; i < arr.length ; i++ ) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max( currArea , maxArea );
        }

        System.out.println("Max area = "+maxArea);
        
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        maxArea(arr);
    }
}
