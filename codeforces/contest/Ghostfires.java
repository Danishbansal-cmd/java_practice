package codeforces.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// use the help of article from this 
// https://codeforces.com/blog/entry/152272

// gpt helped it
// to understand it more run the code

public class Ghostfires {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt();

        for (int i = 0; i < intputNumber; i++) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(ghostfireColors(r, g, b));
        }

        sc.close();
    }

    static String ghostfireColors(int r, int g, int b){
        StringBuilder sb = new StringBuilder();

        // We use PriorityQueue (max-heap) instead of sorting
        // because the "best choice" (max count) changes after EVERY step.
        // Sorting would give a fixed order per iteration, but PQ dynamically updates.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,c) -> c[0]-a[0]);

        pq.add(new int[]{r, 'R'});
        pq.add(new int[]{g, 'G'});
        pq.add(new int[]{b, 'B'});

        while(true){

            // temp stores elements that we temporarily skip
            // This is the MAIN reason PQ works:
            // we don't lose skipped options, we retry them later
            List<int[]> temp = new ArrayList<>();
            boolean placed = false;

            while(!pq.isEmpty()){

                // Always get the current highest count color
                int[] pair = pq.poll();
                int count = pair[0];
                char ch = (char) pair[1];

                if(count == 0) continue;

                int len = sb.length();

                // Constraint check:
                // cannot place same color adjacent or at distance 3
                if((len >= 1 && sb.charAt(len-1) == ch) || 
                (len >= 3 && sb.charAt(len-3) == ch)) {

                    // IMPORTANT:
                    // We DO NOT discard this option
                    // We store it and try the next best color
                    // (This is where PQ differs from sorting approach)
                    temp.add(pair);
                    continue;
                }

                // If valid → place it
                sb.append(ch);
                count--;

                // Add back with updated count
                temp.add(new int[]{count, ch});

                placed = true;
                break;
            }

            // Reinsert ALL skipped elements back into PQ
            // So they are available in future iterations
            for(int[] p : temp){
                pq.add(p);
            }

            // If no valid color can be placed → stop
            if(!placed){
                break;
            }
        }

        return sb.toString();
    }
}

