package leetcode.p0023;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 281. Zigzag Iterator
 * algorithm: Queue
 * time complexity: O(1)
 * space complexity: O(1)
 * Runtime: 2 ms, faster than 62.11%
 * Memory Usage: 39.7 MB, less than 91.27%
 */
public class ZigzagIterator281 {

  private Queue<Iterator<Integer>> queue = new LinkedList<>();

  public ZigzagIterator281(List<Integer> v1, List<Integer> v2) {
    if (!v1.isEmpty()) {
      queue.add(v1.iterator());
    }

    if (!v2.isEmpty()) {
      queue.add(v2.iterator());
    }
  }

  public int next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }

    Iterator<Integer> iter = queue.poll();
    int output = iter.next();

    if (iter.hasNext()) {
      queue.add(iter);
    }

    return output;
  }

  public boolean hasNext() {
    return !queue.isEmpty();
  }

}