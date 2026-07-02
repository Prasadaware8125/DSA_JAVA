// package Java.Java_New.Arrays;
// O(n^2)
public class PrefixSum { 

    public static void prefixSum(int numbers[]) {
        int prefix[] = new int[numbers.length];
        int maxSum = Integer.MIN_VALUE;
        int sum;

        prefix[0] = numbers[0];
        for(int i = 1 ; i<numbers.length ; i++) {
            prefix[i] = numbers[i] + prefix[i-1];
        }

        for(int i = 0 ; i < numbers.length ; i++ ) {
            for(int j = i ; j < numbers.length ; j++) {
                sum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                if( maxSum < sum ) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("Max Sum = "+maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = {1,-2,6,-1,3};
        prefixSum(numbers);
    }
}
