package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// C++: std::map (Ordered Map)
// Implemented as a self-balancing binary search tree (usually Red-Black Tree).
// Keys are always sorted.
// Time Complexity
// Operation	    Best Case	Average Case	Worst Case
// Insert (store)	O(log n)	O(log n)	O(log n)
// Find (fetch)	    O(log n)	O(log n)	O(log n)
// 👉 Always O(log n) because of tree traversal, regardless of input.


// C++:  std::unordered_map (Hash Table)
// Implemented using hashing + buckets.
// Keys are not sorted.
// Time Complexity
// Operation	    Best Case	Average Case	Worst Case
// Insert (store)	O(1)	O(1)	O(n)
// Find (fetch)	    O(1)	O(1)	O(n)



// JAVA: HashMap
// Based on hash table + buckets.
// Each bucket stores entries → originally as a linked list, but since Java 8, 
// if collisions become high, the bucket is converted to a balanced tree (red-black tree) for efficiency.
// Time Complexity
// Operation	Best Case	Average Case	Worst Case
// Insert (put)	O(1)	O(1)	O(log n)
// Fetch (get)	O(1)	O(1)	O(log n)
// Explanation:
// Best/Average Case: Good hash function → uniform distribution → only 1–few items per bucket → O(1).
// Worst Case: All keys collide in the same bucket → stored as red-black tree → O(log n). Before Java 8, worst case was O(n) (linked list traversal).


// JAVA: LinkedHashMap
// Inherits from HashMap, but maintains a doubly-linked list of entries to preserve insertion order (or access order, if configured).
// Otherwise, lookup/insertion complexity is identical to HashMap.
// Time Complexity
// Operation	Best Case	Average Case	Worst Case
// Insert (put)	O(1)	O(1)	O(log n)
// Fetch (get)	O(1)	O(1)	O(log n)
// Extra note:
// The linked list overhead doesn’t change complexity, but memory use is higher and insert/update operations are slightly slower in practice than HashMap.


// Hashing methods
// division, folding and mid-square method

public class HashTheory {
    static int[] freq = new int[100000000];
    public static void main(String[] args){
        // using array hashing
        int[] arr = new int[]{1, 3, 4, 6, 7, 8, 4, 1, 3, 4, 2, 6, 7, 6, 78, 89, 54, 5, 43, 56, 7, 56, 45};
        countFrequency(arr);

        String s = "teri pan di fuddi";
        int[] sFreq = new int[256];
        Arrays.fill(sFreq, 0);
        countCharFrequency(s, sFreq);


        Map<Integer, Integer> mp = new HashMap<>();
        countFrequencyUsingMap(arr, mp);
    }

    public static void countFrequency(int[] arr){
        for(int num : arr){
            freq[num] = freq[num] + 1;
        }

        System.err.println("freq[1]: " + freq[1]);
        System.err.println("freq[2]: " + freq[2]);
        System.err.println("freq[3]: "  + freq[3]);
        System.err.println("freq[5]: "  + freq[5]);
    }

    public static void countFrequencyUsingMap(int[] arr, Map<Integer, Integer> mp){
        for(int num : arr){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        System.err.println("mp.get(1): " + mp.get(1));
        System.err.println("mp.get(3): " + mp.get(3));
        System.err.println("mp.get(5): "  + mp.get(5));
        System.err.println("mp.get(4): "  + mp.get(4));
    }

    public static void countCharFrequency(String s, int[] sFreq){
        for(char ch : s.toCharArray()){
            if(ch != ' '){
                sFreq[ch - 'a']++;
            }
        }

        System.err.println("freq[a]: " + sFreq['a' - 'a']);
        System.err.println("freq[f]: " + sFreq['f' - 'a']);
        System.err.println("freq[b]: "  + sFreq['d' - 'a']);
        System.err.println("freq[d]: "  + sFreq['d' - 'a']);
    }
}
