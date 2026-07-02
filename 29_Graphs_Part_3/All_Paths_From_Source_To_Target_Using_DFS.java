import java.util.ArrayList;

public class All_Paths_From_Source_To_Target_Using_DFS {
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

        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void findAllPaths(ArrayList<Edge>[] graph, int src, int dest, StringBuilder path) {
        if( src == dest ) {
            path.append(dest);
            System.out.println(path);
            return;
        }

        for( int i = 0 ; i < graph[src].size() ; i++ ) {
            Edge e = graph[src].get(i);
            findAllPaths(graph, e.dest, dest, path.append(src));
            path = new StringBuilder("");
        }
    }
    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        create_graph(graph);
        findAllPaths(graph, 5, 1, new StringBuilder(""));
    }
}
