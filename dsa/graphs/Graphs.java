package graphs;
import java.util.*;

public class Graphs {
    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createGraph(int length){
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[length];

        for(int i = 0; i < length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));

        return graph;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createGraph2(int length){
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[length];

        for(int i = 0; i < length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 4, 0));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[3].add(new Edge(3, 5, 0));

        graph[4].add(new Edge(4, 2, 0));
        graph[4].add(new Edge(4, 3, 0));
        graph[4].add(new Edge(4, 5, 0));

        graph[5].add(new Edge(5, 3, 0));
        graph[5].add(new Edge(5, 4, 0));
        graph[5].add(new Edge(5, 6, 0));

        return graph;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createGraph3(int length){
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[length];

        for(int i = 0; i < length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 3, 0));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, 0));
        
        graph[4].add(new Edge(4, 5, 0));

        graph[5].add(new Edge(5, 6, 0));

        graph[6].add(new Edge(6, 5, 0));

        return graph;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createGraph4(int length){
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[length];

        for(int i = 0; i < length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 2, 0));

        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 1, 0));

        return graph;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createGraph5(int length){
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[length];

        for(int i = 0; i < length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 0));

        graph[1].add(new Edge(1, 0, 0));

        return graph;
    }

    // priority is to traverse to all the immediate neighbours of the node
    static void bfs(int current, ArrayList<Edge>[] graph, int length, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(current);

        while(!q.isEmpty()){
            int popped = q.remove();
            if(!visited[popped]){
                System.out.print(popped + " ");
                visited[popped] = true;
                for(int i = 0; i < graph[popped].size(); i++){
                    Edge e = graph[popped].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // priority is to traverse to the first immediate neighbour of the node
    // O(V+E)
    static void dfs(ArrayList<Edge>[] graph, int current, boolean[] visited){
        System.out.print(current + " ");
        visited[current] = true;
        for(int i  = 0; i < graph[current].size(); i++){
            Edge e = graph[current].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }

    // it is used to traverse all the possible paths from src to dest
    // O(V^V)
    static void modifiedDfs(ArrayList<Edge>[] graph, int current, boolean[] visited, String path, int destination){
        if(current == destination){
            System.out.println(path);
            return;
        }
        for(int i  = 0; i < graph[current].size(); i++){
            Edge e = graph[current].get(i);
            visited[current] = true;
            if(!visited[e.dest]){
                modifiedDfs(graph, e.dest, visited, path + String.valueOf(e.dest), destination);
            }
            visited[current] = false;
        }
    }

    public static boolean isCycleDetectedUtil(ArrayList<Edge>[] graph, int current, int parent, boolean[] visited){
        for(int i = 0; i < graph[current].size(); i++){
            Edge e = graph[current].get(i);

            if(visited[e.dest] && parent != e.dest){
                return true;
            }else if(!visited[e.dest]){
                visited[current] = true;
                if(isCycleDetectedUtil(graph, e.dest, current, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void isCycleDetected(ArrayList<Edge>[] graph, int length){
        boolean[] visited = new boolean[length];

        for(int i = 0; i < length; i++){
            if(!visited[i]){
                boolean isCycle = isCycleDetectedUtil(graph, i, 0, visited);
                if(isCycle){
                    System.out.println(isCycle);
                    break;
                }
                
            }
        }
    }

    public static void main(String[] args){
        System.out.println("started");

        /*
           0
            \    3
             \  / \
              2 -- 1

        */
        int graph1Length = 4;
        ArrayList<Edge>[] graph1 = createGraph(graph1Length);
        System.out.println("bfs on graph1: ");
        boolean[] visitedGraph1 = new boolean[graph1Length];
        for(int i = 0; i < graph1Length; i++){
            if(!visitedGraph1[i]){
                bfs(i, graph1, graph1Length, visitedGraph1);
            }
        }
        System.out.println();


        /*
              1  ----  3
            /          | \ 
           0           |  5 --- 6
            \          | /
             2  ----   4

        */
        int graph2Length = 7;
        ArrayList<Edge>[] graph2 = createGraph2(graph2Length);
        System.out.println("bfs on graph2: ");
        boolean[] visited = new boolean[graph2Length];
        for(int i = 0; i < graph2Length; i++){
            if(!visited[i]){
                bfs(i, graph2, graph2Length, visited);
            }
        }
        System.out.println();


        // this would even work for the graphs that is divided into the
        // chunks like this
        /*
              1 --- 3
            /      /     
           0     /        5 --- 6
            \  /         /
             2          4

        */
        int graph3Length = 7;
        ArrayList<Edge>[] graph3 = createGraph3(graph3Length);
        System.out.println("bfs on graph3: ");
        boolean[] visitedGraph3 = new boolean[graph3Length];
        for(int i = 0; i < graph3Length; i++){
            if(!visitedGraph3[i]){
                bfs(i, graph3, graph3Length, visitedGraph3);
            }
        }
        System.out.println();


        System.out.println("dfs on graph3: ");
        boolean[] visitedGraph3dfs = new boolean[graph3Length];
        for(int i = 0; i < graph3Length; i++){
            if(!visitedGraph3dfs[i]){
                dfs(graph3, i, visitedGraph3dfs);
            }
        }
        System.out.println();


        boolean[] visitedGraph2allpathsdfs = new boolean[graph2Length];
        System.out.println("Find all paths using modifiedDfs on graph2: ");
        // it finds all the possible paths from each node
        // one can modify it for only the specific node
        for(int i = 0; i < graph2Length; i++){
            if(!visitedGraph2allpathsdfs[i]){
                modifiedDfs(graph2, i, visitedGraph2allpathsdfs, "" + String.valueOf(i), 5);
            }
        }
        System.out.println();


        System.out.println();
        System.out.println("This is to showcase that the approach used\n to detect the cycles in the directed graph\n cannot be used in directed graphs.");
        System.out.println("Is Cycle Detected in graph4: ");
        System.out.println("In graph4 cycyle presents: ");
        int graph4Length = 3;
        ArrayList<Edge>[] graph4 = createGraph4(graph4Length);
        /*
         *    0
         *   / \
         *  /   \
         * 1 --- 2
         */
        DirectedGraph.isCycleDetected(graph4, graph4Length);


        System.out.println("Is Cycle Detected in graph5: ");
        System.out.println("In graph5 there is no cycle: ");
        // but it is still saying true, that represents that 
        // the approach used to detect the cycles in directed graph
        // cannot be used here
        int graph5Length = 2;
        ArrayList<Edge>[] graph5 = createGraph5(graph5Length);
        /*
         * 0 ------ 1
         */
        DirectedGraph.isCycleDetected(graph5, graph5Length);


        System.out.println();
        System.out.println("using right approach for undirected graph");
        System.out.println("To check for cycle in undirected graph (graph5): ");
        isCycleDetected(graph5, graph5Length);
        
        
        System.out.println("To check for cycle in undirected graph (graph4): ");
        isCycleDetected(graph4, graph4Length);
    }
}