
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_Graph {
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

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for( int i = 0 ; i < n ; i++ ) {
            color[i] = -1;
        }

        
        for( int i = 0 ; i < n ; i++ ) {
            if( color[i] == -1 ) {
                if(isBipartiteUtil(graph, color, i) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isBipartiteUtil(ArrayList<Edge>[] graph, int[] color, int cu) {
        Queue<Integer> q = new LinkedList<>();
        q.add(cu);
        color[cu] = 0;
        while ( q.isEmpty() == false ) {
            int curr = q.remove();
            for( int i = 0 ; i < graph[curr].size() ; i++ ) {
                Edge e = graph[curr].get(i);    
                if( color[e.dest] == -1 ) {
                    color[e.dest] = color[curr] == 0 ? 1 : 0;
                    q.add(e.dest);
                } else if( color[e.dest] == color[curr] ) {
                    return false;
                } else if( color[e.dest] != color[curr] ) {
                    continue;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        create_graph(graph);
        System.out.println(isBipartite(graph));
    }
}
