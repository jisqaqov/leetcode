package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 247. Strobogrammatic Number II
 * algorithm: Math, Recursion
 * time complexity:
 * space complexity:
 * Runtime: 11 ms, faster than 53.46% of Java online submissions
 * Memory Usage: 49.8 MB, less than 100.00% of Java online submissions
 */
public class StrobogrammaticNumberII247 {

  public static void main(String[] args) {
    StrobogrammaticNumberII247 problem = new StrobogrammaticNumberII247();
    problem.test();
  }

  private void test() {
    System.out.println(findStrobogrammatic(3));
  }

  public List<String> findStrobogrammatic(int n) {
    return helper(n, n);
  }

  private List<String> helper(int n, int m) {
    if (n == 0) {
      return new ArrayList<>(Collections.singletonList(""));
    }

    if (n == 1) {
      return Arrays.asList("0", "1", "8");
    }

    List<String> output = new ArrayList<>();

    List<String> list = helper(n - 2, m);

    for (String s : list) {
      if (n != m) {
        output.add("0" + s + "0");
      }

      output.add("1" + s + "1");
      output.add("6" + s + "9");
      output.add("8" + s + "8");
      output.add("9" + s + "6");
    }

    return output;
  }

}
