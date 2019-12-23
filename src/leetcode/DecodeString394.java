package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 394. Decode String
 * algorithm: Stack, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 34.5 MB, less than 100.00% of Java online submissions
 */
public class DecodeString394 {

  public static void main(String[] args) {
    DecodeString394 solution = new DecodeString394();
    solution.test();
  }

  public void test() {
    System.out.println(decodeString("3[a]2[bc]").equals("aaabcbc"));
    System.out.println(decodeString("3[a2[c]]").equals("accaccacc"));
    System.out.println(decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef"));
    System.out.println(decodeString("3[a]2[b4[F]c]").equals("aaabFFFFcbFFFFc"));
    System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")
      .equals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"));
  }

  public String decodeString(String s) {
    Deque<Integer> nums = new ArrayDeque<>();
    Deque<StringBuilder> strings = new ArrayDeque<>();

    StringBuilder output = new StringBuilder();

    int k = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (Character.isDigit(ch)) {
        k = k * 10 + Character.getNumericValue(ch);
      } else if (ch == '[') {
        nums.push(k);
        strings.push(output);

        k = 0;
        output = new StringBuilder();
      } else if (ch == ']') {
        k = nums.pop();

        StringBuilder dec = strings.pop();

        while (k > 0) {
          dec.append(output);
          k--;
        }

        output = dec;
      } else {
        output.append(ch);
      }
    }

    return output.toString();
  }

  private static class V2 {

    public String decodeString(String s) {
      Deque<Integer> stack = new ArrayDeque<>();

      Map<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '[') {
          stack.push(i);
        } else if (s.charAt(i) == ']') {
          map.put(stack.pop(), i);
        }
      }

      return decodeString(s, 0, s.length() - 1, map);
    }

    private String decodeString(String s, int l, int r, Map<Integer, Integer> map) {
      StringBuilder sb = new StringBuilder();

      int k = 0;

      for (int i = l; i <= r; i++) {
        char ch = s.charAt(i);

        if (Character.isDigit(ch)) {
          k = k * 10 + Character.getNumericValue(ch);
        } else if (s.charAt(i) == '[') {
          String dec = decodeString(s, i + 1, map.get(i) - 1, map);

          while (k > 0) {
            sb.append(dec);
            k--;
          }

          i = map.get(i);
        } else {
          sb.append(ch);
        }
      }

      return sb.toString();
    }
  }

}
