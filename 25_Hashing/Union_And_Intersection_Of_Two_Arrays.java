import java.util.HashSet;
public class Union_And_Intersection_Of_Two_Arrays {
    public static void main(String[] args) {
        int[] arr1 = { 7, 3, 9 };
        int[] arr2 = { 6, 3, 9, 2, 9, 4 };

        HashSet<Integer> set = new HashSet<>();

        // Union
        for( int num : arr1 ) {
            set.add(num);
        }

        for( int num : arr2 ) {
            set.add(num);
        }
        for( Integer num : set ) {
            System.out.print(num+" ");
        }
        System.out.println("\nUnion = "+set.size());

        // Clear the Set
        set.clear();

        // Intersection
        for( int num : arr1 ) {
            set.add(num);
        } 

        int count = 0;
        System.out.println();
        for( int num : arr2 ) {
            if( set.contains(num) ) {
                count++;
                System.out.print((num+" "));
                set.remove(num);
            }
        }

        System.out.println("\nIntersection = "+count);
    }
}
