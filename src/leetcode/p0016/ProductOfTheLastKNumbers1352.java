package leetcode.p0016;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 1352. Product of the Last K Numbers
 * algorithm: Array
 * time complexity: O(1)
 * space complexity: O(N)
 * Runtime: 13 ms, faster than 97.98% of Java online submissions
 * Memory Usage: 54.5 MB, less than 100.00% of Java online submissions
 */
public class ProductOfTheLastKNumbers1352 {


  class ProductOfNumbers {

    private int product = 1;
    private List<Integer> prefix = new ArrayList<>();

    public ProductOfNumbers() {
      prefix.add(product);
    }

    public void add(int num) {
      if (num == 0) {
        product = 1;

        prefix.clear();
        prefix.add(1);
      } else {
        product *= num;
        prefix.add(product);
      }
    }

    public int getProduct(int k) {
      if (prefix.size() <= k) {
        return 0;
      }

      int val = prefix.get(prefix.size() - k - 1);
      return (int) (product / val);
    }

  }


}
