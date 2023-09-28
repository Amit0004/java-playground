package interview.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Prints permutations for all string
 * Time Complexity: O(n * n!)
 * Space complexity: O(N)
 */
public class StringPermutations {

  public void findPermutations(String str) {
      List<String> result = new ArrayList<>();
      HashSet<String> combinations = new HashSet<>();
      permutations(str.toCharArray(), 0, str.toCharArray().length - 1, combinations);
      result = new ArrayList<>(combinations);
      Collections.sort(result);
      System.out.println(result.toString());

  }

  public void permutations(char[] arr, int l, int r, HashSet<String> set) {
      if(l == r) {
          set.add(String.valueOf(arr));
          return;
      }

      for(int i = l; i <= r; i++) {
          swap(arr, i, l);
          permutations(arr, l + 1, r, set);
          swap(arr, i, l);
      }
  }


  public void swap(char[] arr, int i , int j) {
      char temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }

    public static void main(String[] args) {
        String input = "ABC";
        StringPermutations sp = new StringPermutations();
        sp.findPermutations(input);
    }
}
