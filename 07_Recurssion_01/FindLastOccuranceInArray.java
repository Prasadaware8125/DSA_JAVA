public class FindLastOccuranceInArray {
    public static int findLastOccrance( int arr[] , int i , int key ) {
        // Base Case
        if( i == arr.length ) {
            return -1;
        }
        // Work
        int isFaund = findLastOccrance(arr, i+1, key);
        if( isFaund == -1 && arr[i] == key ) {
            return i;
        }
        
        return isFaund;
    }

    public static void main(String[] args) {
        int arr[] = {8,3,6,9,5,10,2,5,3};
        System.out.println(findLastOccrance(arr, 0, 5));
    }
}
