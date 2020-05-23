package leetcode.p0016;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Jandos Iskakov
 * problem: 284. Peeking Iterator
 * algorithm: Array
 * time complexity: O(1)
 * space complexity: O(1)
 * Runtime: 4 ms, faster than 99.42% of Java online submissions
 * Memory Usage: 39.5 MB, less than 5.00% of Java online submissions
 */
public class PeekingIterator284 {

  class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer nextVal;

    public PeekingIterator(Iterator<Integer> iterator) {
      this.iter = iterator;

      if (this.iter.hasNext()) {
        this.nextVal = iter.next();
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
        throw new NoSuchElementException();
      }

      int output = nextVal;

      nextVal = iter.hasNext()? iter.next(): null;

      return output;
    }

    @Override
    public boolean hasNext() {
      return nextVal != null;
    }

  }

  class PeekingIteratorV2 implements Iterator<Integer> {
    private Integer peekedVal = null;
    private boolean hasPeeked = false;
    private Iterator<Integer> iter;

    public PeekingIteratorV2(Iterator<Integer> iterator) {
      // initialize any member here.
      this.iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
      if (!hasPeeked) {
        if (!iter.hasNext()) {
          throw new NoSuchElementException();
        }

        peekedVal = iter.next();
        hasPeeked = true;
      }

      return peekedVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
      if (!hasPeeked) {
        if (!iter.hasNext()) {
          throw new NoSuchElementException();
        }

        return iter.next();
      }

      int output = peekedVal;

      peekedVal = null;
      hasPeeked = false;

      return output;
    }

    @Override
    public boolean hasNext() {
      return hasPeeked || iter.hasNext();
    }

  }

}