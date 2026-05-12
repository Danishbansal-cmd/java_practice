package atcoder.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Understory {
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);

        TreeMap<Integer, Integer> mp = new TreeMap<>();
        int q = sc.nextInt();
        int totalTrees = 0;
        for(int i = 0; i < q; i++){
            int m = sc.nextInt();
            Integer height = sc.nextInt();

            if(m == 1){
                totalTrees++;
                mp.put(height, mp.getOrDefault(height, 0) + 1);
                System.out.println(totalTrees);
            }else {
                // Get all entries from the TreeMap whose key (height)
                // is less than or equal to the given 'height'
                // 
                // Since query type 2 means:
                // "Remove all trees with height <= h"
                //
                // headMap(height, true) gives exactly that range:
                // true  -> include 'height' itself
                // false -> would exclude 'height'
                //
                // Example:
                // mp = {3=2, 5=1, 7=4, 10=1}
                // height = 7
                // toRemove = {3=2, 5=1, 7=4}
                NavigableMap<Integer, Integer> toRemove = mp.headMap(height, true);

                List<Integer> keys = new ArrayList<>(toRemove.keySet());
                for(int key : keys){
                    totalTrees -= mp.get(key);
                    mp.remove(key); //  safe removal
                }

                System.out.println(totalTrees);
            }
        }
        sc.close();
    }
}
