package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.*;

public class ArraysStrings {
    public static void main(String args[]){
        String[] str = new String[45];

        for(int i = 0; i < 45; ++i){
            str[i] = String.valueOf(i);
            // System.out.println(str[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; ++i){
            list.add(i);
        }

        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(arr + " this is arr");

        int[][] matrix = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8}
        };

        int[][] jagged = {
            {0, 1, 3},
            {4},
            {5, 6}
        };

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                // System.out.println(matrix[i][j] + " this is matrix");
            }
        }

        for(int i = 0; i < jagged.length; i++){
            for(int j = 0; j < jagged[i].length; j++){
                // System.out.println(jagged[i][j] + " this is jagged");
            }
        }



        Integer[] arr2 = {5, 75, 85, 35, -43, 34, 34,456, 356, -345234, 345};
        Arrays.sort(arr2, Collections.reverseOrder());

        System.out.println(Arrays.stream(arr2).reduce(0, (a,b) -> a+b));
        System.out.println(Array.getLength(arr2));




        // String and its methods
        // these are immutable in java
        String s1 = "     Java is     powerfull    ";
        System.out.println(s1.trim().split(" "));
        System.out.println(s1.substring(0, 15));
        System.out.println(s1.replace("Java", "Python"));

        String joined = s1.join("-", "some value", "java s is cool", "jaasdf");
        System.out.println(joined);


        StringBuilder sb = new StringBuilder();
        sb.append("character 1");
        sb.insert(5, " type haha").reverse();
        System.out.println(sb);


        String text = "asdfasdfasf";
        System.out.println(text.matches("asd"));
    }
}
