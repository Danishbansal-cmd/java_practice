package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 33281;
        List<Integer> result = new ArrayList<>();

        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> added = new HashSet<>();

        for(int i = 1; i < 1000; i++){
            for(int j = i; j < 1000; j++){
                int num = (int) (Math.pow(i, 3) + Math.pow(j, 3));

                if(num > n){
                    break;
                }

                if(seen.contains(num)){
                    if(!added.contains(num)){
                        added.add(num);
                        result.add(num);
                    }
                }else{
                    seen.add(num);
                }
            }
        }

        System.out.println(result);
    }
}
