package leetcode;

import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 364. Nested List Weight Sum II
 * algorithm: DFS
 * time complexity: O(N)
 * space complexity: O(|DEPTH|)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 36.9 MB, less than 7.14% of Java online submissions
 */
public class NestedListWeightSumII364 {

  /**
   * // This is the interface that allows for creating nested lists.
   * // You should not implement it, or speculate about its implementation
   * */
    public interface NestedInteger {
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      Integer getInteger();

      // Set this NestedInteger to hold a single integer.
      void setInteger(int value);

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      void add(NestedInteger ni);

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      List<NestedInteger> getList();
  }

  public int depthSumInverse(List<NestedInteger> nestedList) {
    return calcSum(nestedList, getMaxDepth(nestedList));
  }

  private int calcSum(List<NestedInteger> nestedList, int depth) {
    int sum = 0;

    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) {
        sum += ni.getInteger() * depth;
      } else {
        sum += calcSum(ni.getList(), depth - 1);
      }
    }

    return sum;
  }

  private int getMaxDepth(List<NestedInteger> nestedList) {
    int depth = 0;

    for (NestedInteger ni : nestedList) {
      if (!ni.isInteger()) {
        depth = Math.max(depth, getMaxDepth(ni.getList()));
      }
    }

    return depth + 1;
  }

}