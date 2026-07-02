import java.util.ArrayList;

public class Cycle_Detection_Directed_Graph_Using_DFS {
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
        // Cycle doesn't exits
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));

        // graph[1].add(new Edge(1, 3));

        // graph[2].add(new Edge(2, 3));

        // Cycle exits
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] stack = new boolean[n];

        for( int i = 0 ; i < n ; i++ ) {
            if( vis[i] == false ) {
                if(isCycleUtil(graph, vis, stack, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, boolean[] stack, int curr) {
        vis[curr] = true;
        stack[curr] = true;

        for( int i = 0 ; i < graph[curr].size() ; i++ ) {
            Edge e = graph[curr].get(i);
            if( stack[e.dest] ) {
                return true;
            }
            if( vis[e.dest] == false ) {
                if( isCycleUtil(graph, vis, stack, e.dest) ) {
                    return true;
                }
            }
        }

        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        create_graph(graph);
        System.out.println(isCycle(graph));

        /*
                0------>1<------2
                               /^
                              / |
                             /  |
                            <   |
                            3-->4                        
        */
    }
}
