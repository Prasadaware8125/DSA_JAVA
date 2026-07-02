import java.util.*;
// Chocola Problem

// We are given a bar of chocolate composed of mxn square pieces. One should break the chocolate 
// into single squares. Each break of a part of the chocolate is charged a cost expressed by a positive 
// integer. This cost does not depend on the size of the part that is being broken but only depends on 
// the line the break goes along. Let us denote the costs of breaking along consecutive vertical lines with x1, x2, .., xm-1 and along horizontal lines 
// with y1, y2, ..., yn-1.

// Compute the minimal cost of breaking the whole chocolate into single squares.

// Time complexity = O(m log m + n log n)
// Space complexity = O(1)

public class Chocola_Problem {

    public static void main(String[] args) {
        // int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4};    //m-1
        Integer costHor[] = {4, 1, 2};  //n-1

        // Sorting arrays of cost in decreasing order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        // initial number of cuts (pointers)
        int h = 0, v = 0;
        // initial number of pieces
        int hp = 1, vp = 1;
        // initial cost
        int cost = 0;

        while ( h < costHor.length && v < costVer.length ) {
            if( costVer[v] <= costHor[h]) {     //horizontal cut
                // Do horizontal cut with vertical pieces
                cost += (costHor[h] * vp);
                // horizontal piece increase by one
                hp++;
                // pointer moves by one
                h++;
            } else {
                // Do vertical cut with horizontal pieces
                cost += (costVer[v] * hp);
                // vertical piece increase by one
                vp++;
                // pointer moves by one
                v++;
            }
        }

        // for remaining cuts
        while ( h < costHor.length ) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }
        while ( v < costVer.length ) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Minimum cost of cuts = "+cost);
    }
}