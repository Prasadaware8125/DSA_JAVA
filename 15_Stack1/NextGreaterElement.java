import java.util.Stack;
public class NextGreaterElement {

    public static void nextGreaterElement(int[] arr, int[] nextGreater ) {
        // Approach 1
        // Brute force
        // for( int i = 0 ; i < arr.length-1 ; i++ ) {
        //     int curr = arr[i];
        //     boolean next = false;
        //     int max = 0;
        //     for( int j = i+1 ; j < arr.length ; j++ ) {
        //         if( curr < arr[j] ) {
        //             next = true;
        //             max = arr[j];
        //         }
        //     }
        //     if( next == true ) {
        //         nextGreater[i] = max;
        //     } else {
        //         nextGreater[i] = -1;
        //     } 
        // }

        // Approach 2

        // Step - 1

        Stack<Integer> stack = new Stack<>();

        int n = arr.length-1; 
        for( int i = n ; i >= 0 ; i-- ) {
            while ( !stack.isEmpty() && arr[stack.peek()] <= arr[i] ) {
                stack.pop();
            }

            // Step - 2
            if( stack.isEmpty() ) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[stack.peek()];
            }
            // Step - 3
            stack.push(i);
        }
    }
    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] nextGreater = new int[arr.length];

        nextGreaterElement(arr, nextGreater);

        for( int i = 0 ; i < nextGreater.length ; i++ ) {
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();
    }
}