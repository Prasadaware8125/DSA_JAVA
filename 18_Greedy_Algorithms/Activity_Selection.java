import java.util.*;

public class Activity_Selection {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        // Sort
        int activites[][] = new int[start.length][3];
        for( int i = 0  ; i < start.length ; i++ ) {
            activites[i][0] = i;
            activites[i][1] = start[i];
            activites[i][2] = end[i];
        }

        // Sorting 2d array i.e activites array
        Arrays.sort(activites, Comparator.comparingDouble(o -> o[2]));


        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // !st Activity
        maxAct = 1;
        ans.add(activites[0][0]);
        int lastEnd = activites[0][2];
        for( int i = 1 ; i < end.length ; i++ ) {
            if( activites[i][1] >= lastEnd ) {
                // Activity selected
                maxAct++;
                ans.add(activites[i][0]);
                lastEnd = activites[i][2];
            }
        }

        System.out.println("Max activites = "+maxAct);
        for( int i = 0 ; i < ans.size() ; i++ ) {
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}
