package leetcode.p0006;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 341. Flatten Nested List Iterator
 * algorithm: Stack, Design
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 2 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions
 */
public class FlattenNestedListIterator341 {

  private void test() {

  }

  /**
   * This is the interface that allows for creating nested lists.
   * You should not implement it, or speculate about its implementation
   */
  interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
  }

  public class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
      for (int i = nestedList.size() - 1; i >= 0; i--) {
        stack.push(nestedList.get(i));
      }
    }

    @Override
    public Integer next() {
      return stack.poll().getInteger();
    }

    @Override
    public boolean hasNext() {
      if (stack.isEmpty()) {
        return false;
      }

      while (!stack.isEmpty()) {
        NestedInteger node = stack.peek();

        if (!node.isInteger()) {
          List<NestedInteger> list = stack.poll().getList();

          for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
          }
        } else {
          return true;
        }
      }

      return false;
    }
  }

}
