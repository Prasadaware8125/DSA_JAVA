public class KadanesAlgorithm {

    public static boolean checkAllNegative(int numbers[]) {
        int smallNeg = Integer.MIN_VALUE;
        for( int i = 0 ; i < numbers.length ; i++ ) {
            if( numbers[i] >= 0 ) {
                return true;
            }
            smallNeg = smallNeg < numbers[i] ? smallNeg = numbers[i] : smallNeg;
        }
        System.out.println("All numbers are negative.");
        System.out.println("Smallest Negative Number = "+smallNeg);
        return false;
    }

    public static void kadanesArlgorithm(int numbers[]) {
        if( !checkAllNegative(numbers) ) {
            return;
        }
        int currSum = 0;
        int maxSum = Integer.MAX_VALUE;
        int i = 0;
        while( i < numbers.length ) {
            currSum += numbers[i];
            currSum = currSum < 0 ? currSum = 0 : currSum;
            maxSum = Math.max(currSum,maxSum);
            i++;
        }
        System.out.println("Max Sum = "+maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = {-2,-3,-4,-1,-2,-1,-5,-3};
        kadanesArlgorithm(numbers);
    }
}
