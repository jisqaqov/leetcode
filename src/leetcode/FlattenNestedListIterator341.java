package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 341. Flatten Nested List Iterator
 * algorithm: Stack, Design
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 4 ms, faster than 49.96% of Java online submissions
 * Memory Usage: 37 MB, less than 100.00% of Java online submissions
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
    private Queue<Integer> queue = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
      flatten(nestedList);
    }

    private void flatten(List<NestedInteger> nestedList) {
      Deque<List<NestedInteger>> stack = new ArrayDeque<>();
      Deque<Integer> indexes = new ArrayDeque<>();

      stack.push(nestedList);
      indexes.push(0);

      while (!stack.isEmpty()) {
        List<NestedInteger> list = stack.peek();
        Integer pos = indexes.peek();

        for (; pos < list.size(); pos++) {
          NestedInteger ni = list.get(pos);

          if (ni.isInteger()) {
            queue.add(ni.getInteger());
          } else {
            indexes.pop();
            indexes.push(pos);

            stack.push(ni.getList());
            indexes.push(0);
            
            break;
          }
        }

        if (pos == list.size()) {
          stack.pop();
          indexes.pop();

          if (!stack.isEmpty()) {
            indexes.push(indexes.poll() + 1);
          }
        }
      }
    }

    @Override
    public Integer next() {
      return queue.poll();
    }

    @Override
    public boolean hasNext() {
      return !queue.isEmpty();
    }
  }

  public class NestedIteratorV2 implements Iterator<Integer> {

    private Deque<List<NestedInteger>> stack = new ArrayDeque<>();
    private Deque<Integer> indexes = new ArrayDeque<>();

    public NestedIteratorV2(List<NestedInteger> nestedList) {
      stack.push(nestedList);
      indexes.push(-1);
    }

    @Override
    public Integer next() {
      List<NestedInteger> list = stack.peek();

      int index = indexes.poll() + 1;
      indexes.push(index);

      return list.get(index).getInteger();
    }

    @Override
    public boolean hasNext() {
      if (stack.isEmpty()) {
        return false;
      }

      while (!stack.isEmpty()) {
        List<NestedInteger> list = stack.peek();
        int index = indexes.peek();

        if (index == list.size() - 1) {
          stack.pop();
          indexes.pop();

          if (!stack.isEmpty()) {
            indexes.push(indexes.pop() + 1);
          }
        } else {
          NestedInteger ni = list.get(index + 1);
          if (ni.isInteger()) {
            return true;
          } else {
            stack.push(ni.getList());
            indexes.push(-1);
          }
        }
      }

      return false;
    }
  }

}
