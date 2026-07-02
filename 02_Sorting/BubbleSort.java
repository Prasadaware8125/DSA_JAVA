// TC = O(n^2)
public class BubbleSort {
    public static void bubbleSort( int nums[] ) {
        for( int i = 0 ; i < nums.length - 1 ; i++ ) {
            boolean swap = false;
            for( int j = 0 ; j < nums.length - 1 - i ; j++ ) {
                if( nums[j] > nums[j+1] ) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swap = true;
                }
            }
            if( swap == false ) {
                break;
            }
        }
    }

    public static void printarr( int nums[] ) {
        for( int i = 0 ; i < nums.length ; i++ ) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int nums[] = {5,4,3,2,1};
        bubbleSort(nums);
        printarr(nums);
    }
}
