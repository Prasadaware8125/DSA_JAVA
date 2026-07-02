import java.util.ArrayList;
public class Cycle_Detection_Undirected_Graph_Using_DFS {
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

        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];

        for( int i = 0 ; i < n ; i++ ) {
            if( vis[i] == false ) {
                if( detectCycleUtil(graph, vis, i, -1) ) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
        vis[curr] = true;
        
        for( int i = 0 ; i < graph[curr].size() ; i++ ) {
            Edge e = graph[curr].get(i);
            // Case 3: neighbour is not visited
            if( vis[e.dest] == false ) {
                if( detectCycleUtil(graph, vis, e.dest, curr) ) {
                    return true;
                }
            } 
            // Case 1: neighbour is visited but it is not parent
            else if( vis[e.dest] == true && e.dest != par ) {
                return true;
            }
            // Case 2: neighbour is visited and it is parent
            // Case 2 is not required to write as we are doing "continue" 
            else if( vis[e.dest] == true && e.dest == par ) {
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        create_graph(graph);
        System.out.println(detectCycle(graph));
    }
}
