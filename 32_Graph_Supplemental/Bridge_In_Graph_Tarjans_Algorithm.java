import java.util.ArrayList;

public class Bridge_In_Graph_Tarjans_Algorithm{
    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void create_graph(ArrayList<Edge>[] graph) {
        for( int i = 0 ; i < graph.length ; i++ ) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    // TC = 0(E+V)
    public static void dfs(ArrayList<Edge>[] graph, int curr,int par, int[] dt, int[] low, int time, boolean[] vis) {
        // Visiting curr node
        vis[curr] = true;
        // Update discovery time and low time of curr node by adding 1 in time
        dt[curr] = low[curr] = ++time;

        // traversing graph for neighbours of curr node
        for( int i = 0 ; i < graph[curr].size() ; i++ ) {
            Edge e = graph[curr].get(i);
            // the neighbour and parent is same so do nothing
            if( e.dest == par ) {
                continue;
            } else if( !vis[e.dest] ) {     // the neighbour is not visited
                dfs(graph, e.dest, curr, dt, low, time, vis);   // so visit the neighbour first
                low[curr] = Math.min(low[curr], low[e.dest]);   // then calculate the low for curr node 
                if( dt[curr] < low[e.dest] ) {      // Bridge condition     if discovery time of curr < low time of neighbour then there is bridge between curr and neighbour nodes
                    System.out.println("Bridge: "+curr+" ------ "+e.dest);
                }
            } else if( vis[e.dest] ) {      // if neighbour is already visited
                low[curr] = Math.min(low[curr], dt[e.dest]);    // just calculate low for curr 
            }
        }
    }

    public static void tarjansBridge(ArrayList<Edge>[] graph, int V) {
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;

        boolean[] vis = new boolean[V];

        // Graph traversal
        for( int i = 0 ; i < V ; i++ ) {
            if(!vis[i]) {
                dfs(graph, i, -1, dt, low, time, vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        create_graph(graph);
        tarjansBridge(graph, V);
    }
}