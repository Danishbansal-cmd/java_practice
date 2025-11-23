package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTheUnion {
    public static void main(String[] args){
        int[] a = new int[]{0 , 1, 2, 2, 2, 4, 5, 7, 8, 9, 45, 101};
        int[] b = new int[]{2, 3, 6, 9, 45, 99, 101, 305 };

        System.out.println(Arrays.toString(unionArray(a, b)));
    }

    static int[] unionArray(int[] a, int[] b){
        ArrayList<Integer> i = new ArrayList<>();

        int j = 0, k = 0;
        while(j < a.length && k < b.length){
            if(j > 0 && a[j] == a[j - 1]){
                j++;
            }else if(k > 0 && b[k] == b[k - 1]){
                k++;
            }else if(a[j] == b[k]){
                i.add(a[j]);
                j++;
                k++;
            }else if(a[j] < b[k]){
                i.add(a[j]);
                j++;
            }else{
                i.add(b[k]);
                k++;
            }
        }
        while(j < a.length){
            i.add(a[j]);
            j++;
        }
        while(k < b.length){
            i.add(b[k]);
            k++;
        }

        int[] newa = new int[i.size()];
        for(int l = 0; l < i.size(); l++){
            newa[l] = i.get(l);
        }
        return newa;
    }
}
