public class PrintLargestString {
    public static void main(String []args) {
        // String fruits[] = {"apple","mango","banana"};
        String fruits[] = {"Prasad","Aviraj","Ritesh","Rohit","Varad"};

        String largest = fruits[0];
        for( int i = 1 ; i < fruits.length ; i++ ) {
            if(largest.compareTo(fruits[i]) < 0 ) { // 0 for equal , < 0 for str1 < str2 and > 0 for str1 > str2
                largest = fruits[i];
            }
        }
        System.out.println(largest);
    }
}
