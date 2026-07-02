public class StringBasics {

    public static String subString(String str , int si , int ei) {
        StringBuilder substr = new StringBuilder("");
        for( int i = si ; i < ei ; i++ ) {
            substr.append(str.charAt(i));
        }
        return substr.toString();
    }
    public static void main(String[] args) {
        // String str = "hello";
        // System.out.println(str);
        // int l = str.length(); // String length
        // System.out.println("Length = "+l);

        String str1 = "HelloWorld";
        System.out.println(subString(str1, 0, 6));
        // System.out.println(str1.substring(3));

        String str = "ApnaCollege".replace("l","p");
        System.out.println(str);
    }
}
