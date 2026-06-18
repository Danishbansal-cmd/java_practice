package recursion.backtracking;

import java.util.Arrays;
import java.util.HashMap;

// you are given a string of stickers and the target string
// one can cut out any letter from the stickers and any number of time
// the supply of stickers is unlimited
// return the minimum number of stickers can be used to create the target string
// for little simplicity, all is lowercase

// String[] = ['with','example','science'] target='thehat'
// output: 3
// 2 stickers of 'with' and 1 stciker of 'example'

public class MinimumStickers {
    public static void main(String[] args) {
        // Hardcoded input values
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";

        // Execution
        int result = minimumStickers(stickers, target, target.length());
        
        // Output result
        System.out.println("Stickers: " + Arrays.toString(stickers));
        System.out.println("Target: " + target);
        System.out.println("Minimum stickers needed: " + result);
    }

    static int minimumStickers(String[] stickers, String target, int targetLength){
        int n = stickers.length;
        int[][] stickerCounts = new int[n][26];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < stickers[i].length(); j++){
                int index = stickers[i].charAt(j) - 'a';
                stickerCounts[i][index]++;
            }
        }

        int fullMask = (1 << target.length()) - 1;

        HashMap<Integer, Integer> memo = new HashMap<>();
        int currentMask = 0;
        return dfs(stickerCounts, currentMask, fullMask, target, memo);
    }

    static int dfs(int[][] stickerCounts, int currentMask, int fullMask, String target, HashMap<Integer, Integer> memo){
        if(currentMask == fullMask){
            return 0;
        }

        if(memo.containsKey(currentMask)) {
            return memo.get(currentMask);
        }

        int count = Integer.MAX_VALUE;

        for(int[] sticker : stickerCounts){

            int newMask = currentMask;

            int[] available = sticker.clone();

            for(int i = 0; i < target.length(); i++){
                if((newMask & (1 << i)) != 0){
                    continue;
                }

                char ch = target.charAt(i);

                if(available[ch - 'a'] > 0){
                    available[ch - 'a']--;
                    newMask = newMask | (1<<i);
                }
            }

            if(newMask == currentMask) {
                continue;
            }


            int res = dfs(stickerCounts, newMask, fullMask, target, memo);
            if(res != -1){
                count = Math.min(count, res+1);
            }
        }

        int result = (count == Integer.MAX_VALUE) ? -1 : count;

        memo.put(currentMask, result);

        return result;
    }
}
