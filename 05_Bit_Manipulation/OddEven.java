import java.util.*;
public class OddEven {
    public static void main(String[] args) {
        // If LSB ( least significat bit ) is 0 then num is even
        // If LSB is 1 then num is odd
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number : ");
        int number = sc.nextInt();
        int bitmask = 1;
        if( (number & bitmask) == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
        sc.close();
    }
}
