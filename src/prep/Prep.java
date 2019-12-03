package prep;

import java.util.HashMap;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(numDecodings("12"));//2
    System.out.println(numDecodings("226"));//3
  }

  public int numDecodings(String s) {
    return numDecodings(s, new HashMap<>());
  }

  public int numDecodings(String s, Map<String, Integer> map) {
    if (map.containsKey(s)) {
      return map.get(s);
    }

    int count = 0;

    for (int i = 0; i < Math.min(s.length(), 2); i++) {
      String prefix = s.substring(0, i + 1);
      int num = Integer.parseInt(prefix);
      if (num < 1 || num > 26) {
        break;
      }

      String suffix = s.substring(i + 1);
      if (suffix.isEmpty()) {
        count += 1;
      } else {
        int k = numDecodings(suffix, map);
        if (k > 0) {
          count += k;
        }
      }
    }

    map.put(s, count);

    return map.get(s);
  }


}