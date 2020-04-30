package leetcode;

import java.util.Iterator;

/**
 * @author Jandos Iskakov
 * problem: 284. Peeking Iterator
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 4 ms, faster than 99.42% of Java online submissions
 * Memory Usage: 39.5 MB, less than 5.00% of Java online submissions
 */
public class PeekingIterator284 {

  class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> it;
    private Integer nextVal;

    public PeekingIterator(Iterator<Integer> iterator) {
      this.it = iterator;

      if (it.hasNext()) {
        this.nextVal = it.next();
      }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
      return nextVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
      if (!hasNext()) {
        return null;
      }

      int output = nextVal;

      if (it.hasNext()) {
        nextVal = it.next();
      } else {
        nextVal = null;
      }

      return output;
    }

    @Override
    public boolean hasNext() {
      return nextVal != null || it.hasNext();
    }

  }

}