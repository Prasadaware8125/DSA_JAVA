// Average Time Complexity = O(nlogn)
// Worst Case time Complexity = O(n2)
/*
 Approach :
 Step 1 : Find partition and pivot element
 Step 2 : Sort the elements before and after partition element
 Step 3 : Swap pivot and partition element
 */
public class QuickSort {

    public static void printArr( int arr[] ) {
        for( int i = 0 ; i < arr.length ; i++ ) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void quickSort( int arr[] , int si , int ei ) {
        // Base Case
        if( si >= ei ) {
            return;
        }
        // Pivot / last element
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx-1); //right part
        quickSort(arr, pIdx, ei); // left part
    }

    public static int partition( int arr[] , int si , int ei ) {
        int pivot = arr[ei];
        int i = si-1; // to make place for elements smaller than pivot

        for( int j = si ; j < ei ; j++ ) {
            if( arr[j] <= pivot ) {
                i++;
                // Swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        printArr(arr);
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        printArr(arr);
        return i;
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5};
        printArr(arr);
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
