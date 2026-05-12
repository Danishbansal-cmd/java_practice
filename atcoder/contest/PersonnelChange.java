package atcoder.contest;

import java.util.Scanner;

public class PersonnelChange {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
  
    int n = sc.nextInt();
    int m = sc.nextInt();
    
    int[][] depAB = new int[n+1][2];
    for(int i = 1; i <= n; i++){
      depAB[i][0] = sc.nextInt();
      depAB[i][1] = sc.nextInt();
    }
    
    int[][] result = new int[m+1][2];
    for(int i = 1; i <= n; i++){
      result[depAB[i][0]][0]++;
      result[depAB[i][1]][1]++;
    }
    
    for(int i = 1; i<= m; i++){
      System.out.println(result[i][1] - result[i][0]);
    }
    
    sc.close();
  }
}