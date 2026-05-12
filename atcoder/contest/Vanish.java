package atcoder.contest;
import java.util.*;

public class Vanish{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int k = sc.nextInt();
    
    HashMap<Integer, Integer> mp = new HashMap<>();
    int[] arr = new int[n];
    long sum = 0;
    
    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
      sum += arr[i];
      mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
    }
    
    List<Integer> keys = new ArrayList<>(mp.keySet());
    keys.sort(
      (a,b) -> Integer.compare(b * mp.get(b),a * mp.get(a))
    );
    
    int operations = 0;
    while(operations < k){
      int key = keys.get(operations);
      sum -= key * mp.get(key);
      operations++;
    }
    
    System.out.println(sum);
  }
}