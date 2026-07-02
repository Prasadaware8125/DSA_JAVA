// Input : Sorted, rotated array with distinct numbers ( in ascending order ) It is rotated at a pivot point. Find the index of given element.
// Time Complexity : O(nlogn)
// Modified Binary Search
public class SearchInRotatedSortedArray {

    public static int search( int arr[] , int tar , int si , int ei ) {
        // Base case
        if( si > ei ) {
            return -1;
        }

        // Kaam
        int mid = si + ( ei - si )/2;
        if( arr[mid] == tar ) {
            return mid;
        }

        // mid on L1
        if( arr[si] <= arr[mid] ) {
            // Case 1:
            if( arr[si] <= tar && tar <= arr[mid] ) {
                return search(arr, tar, si, mid);
            } 
            // Case 2:
            else {
                return search(arr, tar, mid+1, ei);
            }
        }
        // Case 3:
        else {
            if( arr[mid+1] <= tar && tar <= arr[ei] ) {
                return search(arr, tar, mid+1, ei);
            } 
            // Case 4:
            else {
                return search(arr, tar, si, mid-1);
            }
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 1, 2, 8, 0};
        int target = 6; 
        int tarIdx = search(arr, target, 0, arr.length-1);
        System.out.println(tarIdx);
    }
}