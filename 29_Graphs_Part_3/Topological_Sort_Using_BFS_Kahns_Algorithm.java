import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Topological_Sort_Using_BFS_Kahns_Algorithm {
    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void create_graph(ArrayList<Edge>[] graph) {
        int n = graph.length;
        for( int i = 0 ; i < n ; i++ ) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void calculateIndgree(ArrayList<Edge>[] graph, int[] inDegree) {
        for( int i = 0 ; i < graph.length ; i++ ) {
            int v = i;
            for( int j = 0 ; j < graph[v].size() ; j++ ) {
                Edge e = graph[v].get(j);
                inDegree[e.dest]++;
            }
        }
    }


    public static void topologicalSort(ArrayList<Edge>[] graph) {
        int n = graph.length;
        int[] inDegree = new int[n];
        // calculate incoming nodes
        calculateIndgree(graph, inDegree);
        Queue<Integer> q = new LinkedList<>();
        // Edge having incoming nodes = 0 i.e inDegree = 0 will be the starting point
        for( int i = 0 ; i < n ; i++ ) {
            if( inDegree[i] == 0 ) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            inDegree[curr]--;
            System.out.print(curr+" ");
            for( int i = 0 ; i < graph[curr].size() ; i++ ) {
                Edge e = graph[curr].get(i);
                inDegree[e.dest]--;
                if( inDegree[e.dest] == 0 ) {
                    q.add(e.dest);
                }
            }
        }

    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        create_graph(graph);
        topologicalSort(graph);
    }
}
