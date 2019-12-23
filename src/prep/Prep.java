package prep;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(decodeString("3[a]2[bc]").equals("aaabcbc"));
    System.out.println(decodeString("3[a2[c]]").equals("accaccacc"));
    System.out.println(decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef"));
  }

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