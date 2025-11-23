package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTheIntersection {
    public static void main(String[] args){
        int[] a = new int[]{0, 1, 2, 2, 2, 4, 5, 7, 8, 9, 45, 101};
        int[] b = new int[]{2, 2, 3, 6, 9, 45, 99, 101, 305 };

        System.out.println(Arrays.toString(intersectionArray(a, b)));
    }

    static int[] intersectionArray(int[] a, int[] b){
        int n1 = a.length;
        int n2 = b.length;
        int[] visited2 = new int[n2];
        Arrays.fill(visited2, 0);

        ArrayList<Integer> inter = new ArrayList<>();

        int i = 0, j = 0;
        while(i < n1){
            if(a[i] == b[j] && visited2[j] == 0){
                inter.add(a[i]);
                visited2[j] = 1;
                i++;
                j++;
            }else if(a[i] < b[j]){
                i++;
            }else{
                j++;
            }
        }

        int[] result = new int[inter.size()];
        for(int p = 0; p < inter.size(); p++){
            result[p] = inter.get(p);
        }

        return result;
    }
}
