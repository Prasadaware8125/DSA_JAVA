import java.util.PriorityQueue;

public class Connect_N_Ropes_With_Minimum_Cost {
    public static int connectRope(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for( int i = 0 ; i < ropes.length ; i++ ) {
            pq.add(ropes[i]);
        }

        int cost = 0;

        while ( pq.size() > 1 ) {
            int r1 = pq.remove();
            int r2 = pq.remove();

            cost = cost + r1 + r2;
            pq.add(r1+r2);
        }

        return cost;
    }
    public static void main(String[] args) {
        int[] ropes = {2, 3, 3, 4, 6};
        System.out.println("The Minimum cost to connet N ropes is: "+ connectRope(ropes));
    }    
}
