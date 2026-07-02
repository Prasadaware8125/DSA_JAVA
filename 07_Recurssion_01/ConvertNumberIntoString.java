public class ConvertNumberIntoString {
    static String[] array = {"zero","one","two","three","four","five","six","seven","eight","nine"};


    public static void printDigits(int num) {
        if( num == 0 ) {
            return;
        }
        int lastDigit = num % 10;
        printDigits(num/10);
        System.out.print(array[lastDigit]+" ");
    }
    public static void main(String[] args) {
        printDigits(1234);      
    }

}
