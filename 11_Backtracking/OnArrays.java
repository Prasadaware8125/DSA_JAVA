// Time Complexity = O(n)
// Space Complextiy = O(n)

public class OnArrays {
    public static void changeArr(int arr[], int i, int val) {
        // Base case
        if( i == arr.length ) {
            printArr(arr);
            return;
        }

        // recursion
        arr[i] = val;
        changeArr(arr, i+1, val+1); // Function Call
        // Kaam
        arr[i] = arr[i] - 2; // Backtracking
    }

    // Function to print Array
    public static void printArr(int arr[] ) {
        for(int i = 0 ; i < arr.length ; i++ ) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = new int[15];
        changeArr(arr, 0, 1);
        printArr(arr);
    }
}
