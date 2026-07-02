import java.util.PriorityQueue;
// TC = O(mn + mlogm)
public class Weakest_Soldier {
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if( this.soldiers == r2.soldiers ) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }    

    public static int[] kWeakSoldiers(int[][] army, int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();
        int[] res = new int[k];
        for( int i = 0 ; i < army.length ; i++ ) {
            int soldiers = 0;
            for( int j = 0 ; j < army[0].length ; j++ ) {
                soldiers += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(soldiers, i));
        }

        for( int i = 0 ; i < k ; i++ ) {
            res[i] = pq.remove().idx;
        }

        return res;
    }


    public static void main(String[] args) {
        int[][] army = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };

        int[] res = kWeakSoldiers(army, 2);
        for( int i = 0 ; i < res.length ; i++ ) {
            System.out.println("R"+res[i]);
        }
    }
}
