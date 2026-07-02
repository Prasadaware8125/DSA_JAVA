/*
Directed Acyclic Graph(DAG) is a directed graph with no cycles.

Topological sorting is used only for DAGs (not for non-DAGs).

It is a linear order of vertices such that every directed edge u -> v, the vertex 
u comes before v in the order.
*/
import java.util.ArrayList;
import java.util.Stack;

public class Topological_Sort_Using_DFS {
    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void create_graph(ArrayList<Edge>[] graph) {
        int n = graph.length;
        for(int i = 0 ; i < n ; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0, 0))

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        Stack<Integer> s = new Stack<>();

        for( int i = 0 ; i < n ; i++ ) {
            if( vis[i] == false ) {
                topologicalSortUtil(graph, vis, s, i);
            }
        }

        while (!s.isEmpty() ) {
            int curr = s.pop();
            System.out.print(curr+" ");
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> s, int curr) {
        vis[curr] = true;
        
        for( int i = 0 ; i < graph[curr].size() ; i++ ) {
            Edge e = graph[curr].get(i);
            if( vis[e.dest] == false ) {
                topologicalSortUtil(graph, vis, s, e.dest);
            }
        }

        s.push(curr);
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        create_graph(graph);
        topologicalSort(graph);
    }
}
