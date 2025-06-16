import java.util.ArrayList;
import java.util.Stack;

public class DirectedGraph {
    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createDirectedGraph1(int length){
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[length];

        for(int i = 0; i < length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(1, 0, 0));

        graph[2].add(new Edge(2, 3, 0));

        graph[3].add(new Edge(3, 0, 0));

        return graph;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createDirectedGraph2(int length){
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[length];

        for(int i = 0; i < length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 0));

        graph[2].add(new Edge(2, 1, 0));
        graph[2].add(new Edge(2, 3, 0));

        graph[3].add(new Edge(3, 4, 0));

        graph[3].add(new Edge(4, 2, 0));

        return graph;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createDirectedGraph3(int length){
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[length];

        for(int i = 0; i < length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[2].add(new Edge(2, 3, 0));

        graph[3].add(new Edge(3, 1, 0));

        graph[4].add(new Edge(4, 0, 0));
        graph[4].add(new Edge(4, 1, 0));

        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));

        return graph;
    }

    // to detect if the cycle is detected in the graph
    public static boolean isCycleDetectedUtil(ArrayList<Edge>[] graph, int current, boolean[] visited, boolean[] rec){
        rec[current] = true;

        for(int i = 0; i < graph[current].size(); i++){
            Edge e = graph[current].get(i);
            if(rec[e.dest]){
                return true;
            }else if(!visited[e.dest]){
                visited[e.dest] = true;
                if(isCycleDetectedUtil(graph, e.dest, visited, rec)){
                    return true;
                }
            }
        }
        rec[current] = false;
        return false;
    }

    public static void isCycleDetected(ArrayList<Edge>[] graph, int length){
        boolean[] visited = new boolean[length];
        boolean[] rec = new boolean[length];

        for(int i = 0; i < length; i++){
            if(!visited[i]){
                boolean isCycle = isCycleDetectedUtil(graph, i, visited, rec);
                if(isCycle){
                    System.out.println(isCycle);
                    break;
                }
            }
        }
    }

    // Topological Sorting
    // it is used in only for DAG(Directed Acyclic Graphs) Acyclic = Graph with no Cycles
    // DAG = It is linear order of vertices such that every directed edge u -> v
    // the vertex, u comes before v in the order
    public static void topSortUtil(ArrayList<Edge>[] graph, boolean[] visited, int current, Stack<Integer> s){
        visited[current] = true;
        for(int i = 0; i < graph[current].size(); i++){
            Edge e = graph[current].get(i);
            if(!visited[e.dest]){
                topSortUtil(graph, visited, e.dest, s);
            }
        }
        s.push(current);
    }

    // O(V + E)
    public static void topSort(ArrayList<Edge>[] graph, int length){
        boolean[] visited = new boolean[length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0;i < length; i++){
            if(!visited[i]){
                topSortUtil(graph, visited, i, s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args){
        System.out.println("Is Cycle Detected in graph1: ");
        int directedGraphLength1 = 4;
        ArrayList<Edge>[] graph1 = createDirectedGraph1(directedGraphLength1);
        /*
           1 -----> 0 <---- 3
                    |      ^
                    |    /
                    V  /
                    2

        */
        isCycleDetected(graph1, directedGraphLength1);


        System.out.println("Is Cycle Detected in graph2: ");
        int directedGraphLength2 = 5;
        ArrayList<Edge>[] graph2 = createDirectedGraph2(directedGraphLength2);
        /*
           0 -----> 1 <----- 2
                           / ^
                          /  |
                         /   |
                        V    |
                        3 -> 4 

        */
        isCycleDetected(graph2, directedGraphLength2);
        

        System.out.println("finding the topological sort: ");
        int directedGraphLength3 = 6;
        ArrayList<Edge>[] graph3 = createDirectedGraph3(directedGraphLength3);
        /*
            5                      4   
            |  \                  /|
            |   \               /  |
            |     \           /    |
            |       \       /      |
            |         V   V        |
            |           0          |
            |                      |
            |                      |
            |                      |
            V                      V
            2 --------> 3 -------> 1
        */
        topSort(graph3, directedGraphLength3);
    }
}
