package graphs;

import java.util.ArrayList;

public class Bridges {
    // Bridge is an edge whose deletion increases the graph's number of connected components
    // It works in undirected graph
    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createUndirectedGraph1(int length){
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[length];

        for(int i = 0; i < length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));
        graph[0].add(new Edge(0, 3, 0));

        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 2, 0));

        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 1, 0));

        graph[3].add(new Edge(3, 0, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[3].add(new Edge(3, 5, 0));

        graph[4].add(new Edge(4, 3, 0));
        graph[4].add(new Edge(4, 5, 0));

        graph[5].add(new Edge(5, 3, 0));
        graph[5].add(new Edge(5, 4, 0));
        return graph;
    }
    public static void tarjanAlgoUtil(ArrayList<Edge>[] graph, int current, int time, boolean[] visited, int dt[], int low[], int currentParent){
        visited[current] = true;
        dt[current] = low[current] = ++time;
        
        for(int i = 0; i < graph[current].size(); i++){
            Edge e = graph[current].get(i);

            int v = e.dest;
            if(currentParent == v){
                continue;
            }else if(!visited[v]){
                tarjanAlgoUtil(graph, v, time, visited, dt, low, current);
                low[current] = Math.min(low[current], low[v]);
                if(dt[current] < low[v]){
                    System.out.println("Bridge is: " + current + "---" + v);
                }
            }else if(visited[v]){
                low[current] = Math.min(low[current], dt[v]);
            }
        }
    }

    public static void getBridge(int length){
        ArrayList<Edge>[] graph = createUndirectedGraph1(length);
        boolean[] visited = new boolean[length];

        // dt[] and low[] is used to track, which node ocuurs first and after that
        // basically to know which node occurs at which time or position
        
        // it is the time to record what is the time, when the node is first time discovered

        // dt = discoveryTime
        int dt[] = new int[length];
        
        // 
        // low = lowest discoveryTime
        int low[] = new int[length];

        int time = 0;
        for(int i = 0;i < length; i++){
            if(!visited[i]){
                tarjanAlgoUtil(graph, i, time, visited, dt, low, -1 );
            }
        }

    }
    public static void main(String[] args){
        System.out.println("Bridges in Graphs: ");
        int createUndirectedLength1 = 6;
        getBridge(createUndirectedLength1);
    }
}
