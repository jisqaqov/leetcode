package prep;

import java.util.HashMap;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(canPermutePalindrome("code"));//false
    System.out.println(canPermutePalindrome("aab"));//true
    System.out.println(canPermutePalindrome("carerac"));//true
  }

  public boolean canPermutePalindrome(String s) {
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    int odds = 0;
    for (char ch : map.keySet()) {
      if (map.get(ch) % 2 > 0) {
        odds++;
      }
    }

    return odds <= 1;
  }


}