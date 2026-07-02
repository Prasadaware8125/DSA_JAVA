public class FindFirstOccuranceInArray {
    public static int findFirstOccurance( int arr[]  , int i , int key ) {
        // Base Case 
        if( i == arr.length) {
            return -1;
        }
        // Work
        if( arr[i] == key ) {
            return i;
        }
        // Inner Call
        return findFirstOccurance(arr,i+1,key);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(findFirstOccurance(arr, 0, 5));
    }
}
