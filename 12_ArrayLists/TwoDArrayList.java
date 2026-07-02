import java.util.ArrayList;
public class TwoDArrayList {

    public static void addLists( ArrayList<ArrayList<Integer>> mainList , int n ) {
        ArrayList<Integer> list = new ArrayList<>();
        for( int i = 0 ; i < 5 ; i++ ) {
            list.add((i+1)*n);
        }
        mainList.add(list);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        addLists(mainList, 1);
        addLists(mainList, 2);
        addLists(mainList, 3);
        // System.out.println(mainList);

        for( int i = 0 ; i < mainList.size() ; i++ ) {
            ArrayList<Integer> currList = mainList.get(i);
            for( int j = 0 ; j < currList.size() ; j++ ) {
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }
    }
}
