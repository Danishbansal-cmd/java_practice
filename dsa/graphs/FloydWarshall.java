package graphs;

import java.util.*;


/*
    Time Complexity ->
        O(V³)
    
    Works for ->
        All-pairs shortest path
        Negative edges allowed
        No negative cycles

    Core Formula ->
        dist[i][j]=min(dist[i][j], dist[i][k]+dist[k][j])
*/

public class FloydWarshall {
    static final int INF = 1000000000;
    public static void floydWarshall(int V, ArrayList<Edge> edges) {

        int[][] dist = new int[V][V];

        // Initialize
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {

                if(i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        // Fill graph edges
        for(Edge e : edges) {
            dist[e.src][e.dest] = e.wt;
        }

        // Floyd Warshall
        for(int k = 0; k < V; k++) {

            for(int i = 0; i < V; i++) {

                for(int j = 0; j < V; j++) {

                    if(dist[i][k] == INF ||
                       dist[k][j] == INF) {
                        continue;
                    }

                    dist[i][j] =
                        Math.min(dist[i][j],
                                 dist[i][k] + dist[k][j]);
                }
            }
        }

        // Print matrix
        System.out.println("All Pair Shortest Paths:");

        for(int i = 0; i < V; i++) {

            for(int j = 0; j < V; j++) {

                if(dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0,1,5));
        edges.add(new Edge(0,3,10));
        edges.add(new Edge(1,2,3));
        edges.add(new Edge(2,3,1));

        floydWarshall(V, edges);
    }
}