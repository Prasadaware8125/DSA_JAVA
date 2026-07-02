// Question1:For a given integer array of size N. You have to find all the occurrences 
// (indices) of a given element (Key) and print them. Use a recursive function to solve this 
// problem.
public class Q1 {
    public static int printOccurances( int arr[] , int idx , int key ) {
        // Base Case
        if( idx == arr.length ) {
            return -1;
        }
        // Work
        if( arr[idx] == key ) {
            System.out.print(idx+" ");
        }
        return printOccurances(arr, idx+1, key);
    }

    public static void main(String[] args) {
        int arr[] = {3,2,4,5,6,2,7,2,2};
        printOccurances(arr, 0, 2);
    }
}
