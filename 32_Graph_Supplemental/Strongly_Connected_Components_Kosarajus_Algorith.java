import java.util.ArrayList;
import java.util.Stack;

// TC = O(E+V)
public class Strongly_Connected_Components_Kosarajus_Algorith {
    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }    

    public static void create_graph(ArrayList<Edge>[] graph) {
        for( int i = 0 ; i< graph.length ; i++ ) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> s, int curr) {
        vis[curr] = true;

        for( int i = 0 ; i < graph[curr].size() ; i++ ) {
            Edge e = graph[curr].get(i);
            if( !vis[e.dest] ) {
                topSort(graph, vis, s, e.dest);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge>[] transpose, boolean[] vis, int curr) {
        vis[curr] = true;
        System.out.print(curr+" ");
        
        for( int i = 0 ; i < transpose[curr].size() ; i++ ) {
            Edge e = transpose[curr].get(i);
            if( !vis[e.dest] ) {
                dfs(transpose, vis, e.dest);
            }
        }
    }

    public static void kosarajusAlgorithm(ArrayList<Edge>[] graph, int V) {
        
        boolean[] vis = new boolean[V];
        Stack<Integer> s = new Stack<>();
        // Step : 1 => TopSort -> Add vertices to stack
        for( int i = 0 ; i < V ; i++ ) {
            if( !vis[i] ) {
                topSort(graph, vis, s, i);
            }
        }

        // Step : 2 => Make Transpose of graph i.e src -> dest   to   dest -> src
        // Reverse the edges
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] transpose = new ArrayList[V];

        for( int i = 0 ; i < V ; i++ ) {
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for( int i = 0 ; i < V ; i++ ) {
            for( int j = 0 ; j < graph[i].size() ; j++ ) {
                Edge e = graph[i].get(j);
                
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step : 3 => DFS traversal by removing stack elements
        while( !s.isEmpty() ) {
            int curr = s.pop();

            if( !vis[curr] ) {
                dfs(transpose, vis, curr);
                System.out.println();
            }
        }

    }


    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        create_graph(graph);
        kosarajusAlgorithm(graph, V);
    }
}
