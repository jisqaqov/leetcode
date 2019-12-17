package facebook;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jandos Iskakov
 * algorithm: Recursion
 * time complexity: O(N)
 * space complexity: O(D), D - max depth of nested list
 * variation of https://leetcode.com/problems/nested-list-weight-sum/
 * e.g. Input = [ [2, 1], 6, [1, [4, 3]] ], output = 2*(2+1)+6+2*(1+3*(4+3)) = 56
 */
public class NestedListWeightSum {

  public static void main(String[] args) {
    NestedListWeightSum problem = new NestedListWeightSum();
    problem.test();
  }

  private void test() {
    System.out.println(depthSum(
      Arrays.asList(
        new NestedList(Arrays.asList(new NestedNumber(2), new NestedNumber(1))),
        new NestedNumber(6),
        new NestedList(Arrays.asList(new NestedNumber(1),
          new NestedList(Arrays.asList(new NestedNumber(4), new NestedNumber(3)))))
      )));
  }

  public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
  }

  private int depthSum(List<NestedInteger> nestedList, int depth) {
    int s = 0;

    for (NestedInteger nestedInteger : nestedList) {
      if (nestedInteger.isInteger()) {
        s += nestedInteger.getInteger();
      } else {
        s += depthSum(nestedInteger.getList(), depth + 1);
      }
    }

    return s * depth;
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

  private class NestedNumber implements NestedInteger {

    private Integer value;

    public NestedNumber(Integer value) {
      this.value = value;
    }

    @Override
    public boolean isInteger() {
      return true;
    }

    @Override
    public Integer getInteger() {
      return value;
    }

    @Override
    public void setInteger(int value) {
      this.value = value;
    }

    @Override
    public void add(NestedInteger ni) {

    }

    @Override
    public List<NestedInteger> getList() {
      return null;
    }
  }

  private class NestedList implements NestedInteger {

    private List<NestedInteger> list;

    public NestedList(List<NestedInteger> list) {
      this.list = list;
    }

    @Override
    public boolean isInteger() {
      return false;
    }

    @Override
    public Integer getInteger() {
      return null;
    }

    @Override
    public void setInteger(int value) {

    }

    @Override
    public void add(NestedInteger ni) {
      list.add(ni);
    }

    @Override
    public List<NestedInteger> getList() {
      return list;
    }
  }

}
