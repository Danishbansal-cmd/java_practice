package classTest;

import java.util.*;



/*
    Similar to 
    https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1

    Breifly described problem statement ->
    * Starting from start, repeatedly multiply by any value in arr and take % 100000, 
    find minimum steps to reach end
*/
public class MinSteps {

    public int minSteps(int start, int end, int[] arr) {
        if (start == end)
            return 0;

        int MOD = 100000;


        // using the bfs
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[MOD];

        q.offer(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int num = curr[0];
            int steps = curr[1];

            for (int multiplier : arr) {

                int next = (int)(((long) num * multiplier) % MOD);

                if (next == end)
                    return steps + 1;

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, steps + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        MinSteps obj = new MinSteps();

        int[] arr = {2, 5, 7};
        int start = 3;
        int end = 30;

        int ans = obj.minSteps(start, end, arr);

        System.out.println("Minimum Steps = " + ans);
    }
}