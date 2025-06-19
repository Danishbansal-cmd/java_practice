package graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SCC {
    // A Strongly Connected Component (SCC) of a directed graph is a maximal subset of vertices such that:
    // vertices such that:
    // 🔁 Every vertex is reachable from every other vertex in that subset.
    // In simpler terms:
    // For every pair of vertices (u, v) in an SCC, there exists:
    // a path from u to v
    // and a path from v to u

    // Consider this directed graph:
    // 0 → 1 → 2
    // ↑   ↓   ↓
    // 4 ← 3 ← 5

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createDirectedGraph1(int length){
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[length];

        for(int i = 0; i < length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        /*
        
        2 <------- 0 -------> 3
        |        ^            |
        |      /              |
        |    /                V
        V  /                  4
        1

         */

        graph[0].add(new Edge(0, 3, 0));
        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(1, 0, 0));

        graph[2].add(new Edge(2, 1, 0));

        graph[3].add(new Edge(3, 4, 40));

        return graph;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] transposeGraph(ArrayList<Edge>[] graph) {
        int n = graph.length;  // Number of vertices in the graph

        // Step 1: Create a new empty adjacency list for the transposed graph
        ArrayList<Edge>[] newGraph = (ArrayList<Edge>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            newGraph[i] = new ArrayList<Edge>();  // Initialize each list
        }

        // Step 2: Traverse the original graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);  // Get original edge

                int u = e.src;  // Original source
                int v = e.dest; // Original destination

                // Step 3: Reverse the edge and add to the transposed graph
                newGraph[v].add(new Edge(v, u, 0));
                // Note: We reverse direction by adding an edge from v → u (instead of u → v)
                // Weight is set to 0 if weights are not relevant in the transposed graph
            }
        }

        // Step 4: Return the new transposed graph
        return newGraph;
    }



    // Kosaraju's Algorithm Psuedo-Code
    // Step 1. Get nodes in stack (topological sort) = O(V + E)
    // Step 2. Transpose the graph = O(V + E)
    // Step 3. Do DFS according to stack nodes on the transpose graph = O(V + E)
    // O(V + E)
    public static void kosarajuAlgoUtil(ArrayList<Edge>[] graph, int current, Stack<Integer> s, boolean[] visited){
        visited[current] = true;
        for(int i = 0; i < graph[current].size(); i++){
            Edge e = graph[current].get(i);
            if(!visited[e.dest]){
                kosarajuAlgoUtil(graph, e.dest, s, visited);
            }
        }
        s.push(current);
    }

    public static void kosarajuAlgoRunMain(int length){
        ArrayList<Edge>[] graph = createDirectedGraph1(length);

        // Step 1 - O(V + E)
        boolean[] visited = new boolean[length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i < length; i++){
            if(!visited[i]){
                DirectedGraph.topSortUtil(graph, visited, i, s);
            }
        }

        // Step 2 - O(V + E)
        ArrayList<Edge>[] reversedGraph = transposeGraph(graph);

        // Step 3 - O(V + E)
        Arrays.fill(visited, false);
        int totolSccCount = 0;
        while(!s.isEmpty()){
            int popped = s.pop();
            if(!visited[popped]){
                totolSccCount++;
                Graphs.dfs(reversedGraph, popped, visited);
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Total SCC Count: " + totolSccCount);
    }

    public static void main(String[] args) {
        System.out.println("Strongly Connected Component");
        int directedGraphLength1 = 5;
        kosarajuAlgoRunMain(directedGraphLength1);
    }
}
