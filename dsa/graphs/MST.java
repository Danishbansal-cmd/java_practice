package graphs;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST{
    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int n, int c){
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p){
            return this.cost - p.cost;
        }
    }
    // A Minimum Spanning Tree (MST) or minimum weight spanning tree is a subset of
    // the edges of a connected, edge-weighted undirected graph that connects all the
    // vertices together, without any cycles and with the 
    // minimum possible total edge weight.

    // Requirements for MST
    // Undirected, conntected to all vertices, weighted

    // Properties of MST
    // nodes all conntected, no cycyle, edge weight

    // To find the MST of the graph, the "Prims Algorithm" is used


    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createUndirectedGraph1(int length){
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[length];

        for(int i = 0; i < length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

        return graph;
    }

    // O(E LogE), the reason behind for this time complexity is that in the 
    // worst case, it traverse to the each edge and add to the PriorityQueue 
    // and then this queuqe sort it, so that is why this is the time-complexity
    // this prims algo
    public static int primsAlgoUtil(ArrayList<Edge>[] graph, int current, int length){
        boolean[] visited = new boolean[length];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(current, 0));

        int totalCost = 0;

        while(!q.isEmpty()){
            Pair p = q.remove();
            int node = p.node;
            if(!visited[node]){
                visited[node] = true;
                totalCost += p.cost;

                for(int i = 0; i < graph[node].size(); i++){
                    Edge e = graph[node].get(i);

                    int v = e.dest;
                    int wt = e.wt;
                    q.add(new Pair(v, wt));
                }
            }
        }

        return totalCost;
    }

    public static void primsAlgoRunMain(int length){
        ArrayList<Edge>[] graph = createUndirectedGraph1(length);

        int mstLength = primsAlgoUtil(graph, 0, length);
        System.out.println("Minimum cost of mst is: " + mstLength);
    }
    public static void main(String[] args){
        int createUndirectedLength1 = 4;
        primsAlgoRunMain(createUndirectedLength1);
    }
}