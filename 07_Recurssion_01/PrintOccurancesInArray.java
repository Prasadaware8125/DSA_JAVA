public class PrintOccurancesInArray {
    public static int printOccurances( int arr[] , int i , int key ) {
        // Base Case
        if( i == arr.length ) {
            return -1;
        }
        // Work
        if( arr[i] == key ) {
            System.out.print(i+" ");
        }
        return printOccurances(arr, i+1, key);
    }

    public static void main(String[] args) {
        int arr[] = {1,5,2,3,2,6,8,9,2,4};
        printOccurances(arr, 0, 2);
    }
}
