package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 299. Bulls and Cows
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(N+M)
 * Runtime: 3 ms, faster than 91.58% of Java online submissions
 * Memory Usage: 38.8 MB, less than 42.10% of Java online submissions
 */
public class BullsAndCows299 {

  public static void main(String[] args) {
    BullsAndCows299 problem = new BullsAndCows299();
    problem.test();
  }

  private void test() {
    System.out.println(getHint("1807", "7810"));
    System.out.println(getHint("1123", "0111"));
  }

  public String getHint(String secret, String guess) {
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();

    int bulls = 0;

    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bulls++;
      } else {
        map1.put(secret.charAt(i), map1.getOrDefault(secret.charAt(i), 0) + 1);
        map2.put(guess.charAt(i), map2.getOrDefault(guess.charAt(i), 0) + 1);
      }
    }

    int cows = 0;

    for (char ch : map1.keySet()) {
      cows += Math.min(map1.get(ch), map2.getOrDefault(ch, 0));
    }

    return bulls + "A"
      + cows + "B";
  }

}
