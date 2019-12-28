package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 247. Strobogrammatic Number II
 * algorithm: Math, Recursion
 * time complexity:
 * space complexity:
 * Runtime: 41 ms, faster than 5.25% of Java online submissions
 * Memory Usage: 50.5 MB, less than 100.00% of Java online submissions
 */
public class StrobogrammaticNumberII247 {

  public static void main(String[] args) {
    StrobogrammaticNumberII247 problem = new StrobogrammaticNumberII247();
    problem.test();
  }

  private void test() {
    System.out.println(findStrobogrammatic(4));
  }

  public List<String> findStrobogrammatic(int n) {
    if (n == 0) {
      return Collections.emptyList();
    } else if (n == 1) {
      return Arrays.asList("0", "1", "8");
    } else if (n == 2) {
      return Arrays.asList("11", "69", "88", "96");
    }

    Set<String> output = new LinkedHashSet<>();

    List<String> sub = findStrobogrammatic(n - 2);

    int[] nums = {0, 1, 8, 9, 6};

    for (int num : nums) {
      for (String s : sub) {
        char[] chs = new char[n];

        int y = num == 9 ? 6 : num == 6 ? 9 : num;

        chs[0] = (char) (num + '0');
        chs[n - 1] = (char) (y + '0');

        for (int i = 1; i <= n - 2; i++) {
          chs[i] = s.charAt(i - 1);
        }

        if (num != 0) {
          output.add(String.valueOf(chs));
        }

        int i = 0;
        int j = n - 1;

        while (j - i > 2) {
          swap(i, i + 1, chs);
          swap(j, j - 1, chs);

          i++;
          j--;

          output.add(String.valueOf(chs));
        }
      }
    }

    return new ArrayList<>(output);
  }

  private void swap(int i, int j, char[] chs) {
    char temp = chs[j];
    chs[j] = chs[i];
    chs[i] = temp;
  }

}
