import java.util.ArrayList;

public class Articulation_Point_Tarjans_Algorithm {
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

        graph[4].add(new Edge(4, 3));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, boolean[] vis, int[] dt, int[] ldt, int time, boolean[] isAp) {
        vis[curr] = true;
        dt[curr] = ldt[curr] = ++time;
        // to track number of childrens
        int children = 0;

        for( int i = 0 ; i < graph[curr].size() ; i++ ) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if( neigh == par ) {
                continue;
            } else if( !vis[neigh] ) {
                dfs(graph, neigh, curr, vis, dt, ldt, time, isAp);  
                ldt[curr] = Math.min(ldt[curr], ldt[neigh]);
                if( par != -1 && dt[curr] <= ldt[neigh] ) {     // AP condition 2 for nodes exept root or initial node
                    isAp[curr] = true;
                }
                children++;     // increse number of children (unvisited neighbours)
            } else if( vis[neigh] ) {
                ldt[curr] = Math.min(ldt[curr], dt[neigh]);
            }
        }

        // AP condition 1 for initial node
        if( par == -1 && children > 1 ) {
            isAp[curr] = true;
        }
    }

    public static void findAP(ArrayList<Edge>[] graph, int V) {
        // to track discovery time and lowest discovery time
        int[] dt = new int[V];
        int[] ldt = new int[V];

        // to avoid cycles
        boolean[] vis = new boolean[V];
        // to avoid getting same ap multiple times
        boolean[] isAP = new boolean[V];

        // graph traversal
        for( int i = 0 ; i < V ; i++ ) {
            if( !vis[i] ) {
                dfs(graph, i, -1, vis, dt, ldt, i, isAP);
            }
        }

        // print ap
        for( int i = 0 ; i < V ; i++ ) {
            if( isAP[i] ) {
                System.out.println("AP: "+i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        create_graph(graph);

        findAP(graph, V);
    }
}
