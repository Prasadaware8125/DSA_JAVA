public class SelectionSort {

    public static void selectionSort( int nums[] ) {
        for( int i = 0 ; i < nums.length  ; i++ ) {
            int minPosition = i;
            for( int j = i+1 ; j < nums.length ; j++ ) {
                if( nums[minPosition] > nums[j] ) {
                minPosition = j;
                }
            }
            int temp = nums[minPosition];
            nums[minPosition] = nums[i];
            nums[i] = temp;
        }
    }

    public static void printarr( int nums[] ) {
        for( int i = 0 ; i < nums.length ; i++ ) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {7,8,3,1,2,0,-1};
        selectionSort(nums);
        printarr(nums);
    }
}
