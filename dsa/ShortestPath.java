import java.util.ArrayList;
import java.util.PriorityQueue;

public class ShortestPath {
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p){
            return this.dist - p.dist;
        }
    }
    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createDirectedGraph1(int length){
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[length];
        
        for(int i = 0; i < length; i++){
            graph[i] = new ArrayList<>();
        }

        /*      1 -------------> 3 
              ^ |                ^  \
            /   |                |   \
          /     |                |    V
        0       |                |      5
          \     |                |     ^
            \   |                |   /
              V V                | /
                2 -------------> 4
         */

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
        return graph;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createDirectedGraph2(int length){
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[length];
        
        for(int i = 0; i < length; i++){
            graph[i] = new ArrayList<>();
        }

        /*      1 <------------------
              ^ |           -1      |
          2 /   |                   |
          /     |-4                 |
        0       |                   4
          \     |                   ^ 
         4  \   |                 / 4
              V V               /
                2  ---------> 3
                        2
         */

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
        return graph;
    }

    // O(E + E logV)
    // Use Case:
    // It works in cases where weight of edges is positive or greater than 0
    public static void dijkstraUtil(ArrayList<Edge>[] graph, int current, int length){
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(current, 0));
        int[] distance = new int[length];
        boolean[] visited = new boolean[length];

        for(int i = 0; i < length; i++){
            if(i == current){
                distance[i] = 0;
            }else{
                distance[i] = Integer.MAX_VALUE;
            }
        }

        while(!q.isEmpty()){
            Pair p = q.remove();
            int node = p.node;

            if(!visited[node]){
                visited[node] = true;

                for(int i = 0; i < graph[node].size(); i++){
                    Edge e = graph[node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(distance[u] + wt < distance[v]){
                        distance[v] = distance[u] + wt;
                        q.add(new Pair(v, distance[v]));
                    }
                }
            }
        }

        System.out.println();
        System.out.println("Shortest distance from node this " + current + " to all other nodes");
        for(int i = 0; i < length; i++){
            System.out.print(distance[i] + " ");
        }
    }

    public static void dijkstraRunMain(int length){
        ArrayList<Edge>[] graph = createDirectedGraph1(length);

        for(int i = 0; i < length; i++){
            dijkstraUtil(graph, i, length);
        }
    }


    // O(V.E)  [Where V is number of Vertices, E is the Edges of the vertices]
    // BellMan Ford Algorithm: it uses the concept of dynamic programming
    public static void bellmanFordUtil(ArrayList<Edge>[] graph, int current, int length){
        int[] distance = new int[length];

        for(int i = 0; i < length; i++){
            if(i != current){
                distance[i] = Integer.MAX_VALUE;
            }else{
                distance[i] = 0;
            }
        }

        // run this loop (n - 1) times to ensure that, it gets the correct distance to all nodes
        // Why it runs (n - 1) times to ensure that, the reason is in any graph for the longest possible
        // path there could be only (n - 1) vertices in the src to dest
        //  1 ---> 2 ---> 3 (Total nodes: 3)
        // Now there are maximum of only (n - 1) vertices or nodes between 1 and 3 that is (1 and 2)
        for(int i = 0; i < length - 1; i++){  // O(V)
            // O(E)
            // get to each node, j also represents each node or vertices
            for(int j = 0 ; j < length; j++){
                // get or fetch each nodes edges
                for(int k = 0; k < graph[j].size(); k++){
                    Edge e = graph[j].get(k);

                    int v = e.dest;
                    int wt = e.wt;

                    // In java if we add someting in Integer.MAX_VALUE 
                    // then it becomes negative, so need to put this condition
                    // that distance[j] should not be equal to max_value
                    if(distance[j] != Integer.MAX_VALUE && distance[j] + wt < distance[v]){
                        distance[v] = distance[j] + wt;
                    }
                }
            }
        }
        // detect Negative Weight cycle in Bellman Ford Algorithm
        // It works in this way, as after running the BFA above
        // and running this loop for 1 more time and if in this loop
        // the updation is still happening after properly running the
        // BFA than it means there is negative Weight Cycle
        for(int j = 0 ; j < length; j++){
            // get or fetch each nodes edges
            for(int k = 0; k < graph[j].size(); k++){
                Edge e = graph[j].get(k);

                int v = e.dest;
                int wt = e.wt;

                // In java if we add someting in Integer.MAX_VALUE 
                // then it becomes negative, so need to put this condition
                // that distance[j] should not be equal to max_value
                if(distance[j] != Integer.MAX_VALUE && distance[j] + wt < distance[v]){
                    System.out.println("There is Negative Weight Cycle");
                }
            }
        }

        System.out.println("Printing the shotest distance from " + current + " to all other edges: ");
        for(int i = 0; i < length; i++){
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }
    // NOTE: Bellman Ford Algo does not work for Negative Weight Cycles
    // Or we can say that, one cannot find the shortest distance for the 
    // Negative weight cycles
    public static void bellmanFordRunMain(int length){
        System.out.println("Running the bellman ford algorithm, \nthat even works for negative edges: ");
        ArrayList<Edge>[] graph = createDirectedGraph2(length);

        for(int i = 0; i < length; i++){
            bellmanFordUtil(graph, i, length);
        }
    }
    
    public static void main(String[] args){
        int directedGraphLength1 = 6;
        dijkstraRunMain(directedGraphLength1);

        
        System.out.println();
        System.out.println();
        int directedGraphLength2 = 5;
        bellmanFordRunMain(directedGraphLength2);
    }
}