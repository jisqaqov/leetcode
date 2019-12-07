package leetcode;

import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 339. Nested List Weight Sum
 * algorithm: DFS
 * time complexity: O(N)
 * space complexity: O(D)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Nested List Weight Sum.
 * Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Nested List Weight Sum.
 */
public class NestedListWeightSum339 {

  public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
  }

  private int depthSum(List<NestedInteger> nestedList, int depth) {
    int s = 0;

    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) {
        s += ni.getInteger() * depth;
      } else {
        s += depthSum(ni.getList(), depth + 1);
      }
    }

    return s;
  }

  /**
   * This is the interface that allows for creating nested lists. // You should not implement it, or
   * speculate about its implementation
   */
  interface NestedInteger {

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


}
