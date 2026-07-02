import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims_Algorithm {
    static class Edge{
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }    

    static class Pair implements Comparable<Pair> {
        int vertex, cost;
        public Pair(int v, int c) {
            this.vertex = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void create_graph(ArrayList<Edge>[] graph) {
        for( int i = 0 ; i < graph.length ; i++ ) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 10));
        graph[3].add(new Edge(3, 2, 50));
    }

    // O(ElogE)
    public static int primsAlgorithm(ArrayList<Edge>[] graph, int src) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        int cost = 0;
        ArrayList<Pair> ans = new ArrayList<>();
        
        while( !pq.isEmpty() ) {
            Pair curr = pq.remove();
            if(vis[curr.vertex] == false){
                vis[curr.vertex] = true;
                cost += curr.cost;
                ans.add(curr);

                for( int i = 0 ; i < graph[curr.vertex].size() ; i++ ) {
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        for( Pair a : ans ) {
            System.out.println(a.vertex+" with cost = "+a.cost);
        }
        System.out.println();
        return cost;
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        create_graph(graph);
        System.out.println("Total minimum cost = "+primsAlgorithm(graph, 0));
    }
}
