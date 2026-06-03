package graphs;

import java.util.*;


/*  Time Complexity
    O(V × E) 

    Works for ->
        Directed graphs
        Negative edge weights
        Detecting negative cycles
*/


public class BellmanFord {

    public static void bellmanFord(ArrayList<Edge> edges, int V, int src) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // Relax all edges V-1 times
        for(int i = 1; i <= V - 1; i++) {

            for(Edge e : edges) {

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(dist[u] != Integer.MAX_VALUE &&
                   dist[u] + wt < dist[v]) {

                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Check for negative cycle
        for(Edge e : edges) {

            int u = e.src;
            int v = e.dest;
            int wt = e.wt;

            if(dist[u] != Integer.MAX_VALUE &&
               dist[u] + wt < dist[v]) {

                System.out.println("Negative Weight Cycle Found");
                return;
            }
        }

        System.out.println("Shortest Distances:");

        for(int i = 0; i < V; i++) {
            System.out.println(src + " -> " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0,1,6));
        edges.add(new Edge(0,2,7));
        edges.add(new Edge(1,2,8));
        edges.add(new Edge(1,3,5));
        edges.add(new Edge(1,4,-4));
        edges.add(new Edge(2,3,-3));
        edges.add(new Edge(2,4,9));
        edges.add(new Edge(3,1,-2));
        edges.add(new Edge(4,3,7));

        bellmanFord(edges, V, 0);
    }
}