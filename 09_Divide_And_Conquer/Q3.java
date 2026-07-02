public class Q3 {

    static int count = 0;
    public static void inversionCount( int[] arr , int si , int ei ) {
        if( si >= ei ) {
            return;
        }

        int mid = si + ( ei - si) / 2;
        inversionCount(arr, si, mid);
        inversionCount(arr, mid+1, ei);

        merge(arr,si,mid,ei);
    }

    public static void merge( int arr[] , int si , int mid , int ei ) {
        int i = si;
        int j = mid+1; 
        int k = 0;

        int temp[] = new int[ei-si+1];
        while (i <= mid && j <= ei ) {
            if( arr[i] < arr[j] ) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
                count += (si-1);
            }
        }

        while( i <= mid ) {
            temp[k++] = arr[i++];
        }

        while( j <= ei ) {
            temp[k++] = arr[j++];
            // count++;
        }

    }
    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 5};
        inversionCount(arr, 0, arr.length-1);
        System.out.println(count);
    }
}
