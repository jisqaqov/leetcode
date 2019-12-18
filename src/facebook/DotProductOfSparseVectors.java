package facebook;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: Suppose we have very large sparse vectors (most of the elements in vector are zeros)
 *
 * Find a data structure to store them
 * Compute the Dot Product.
 * Follow-up:
 * What if one of the vectors is very small?
 *
 * algorithm: Two Pointers
 * time complexity: O(|A| + |B|)
 * space complexity: O(1)
 */
public class DotProductOfSparseVectors {

  public static void main(String[] args) {
    DotProductOfSparseVectors problem = new DotProductOfSparseVectors();
    problem.test();
    problem.testV2();
  }

  private void test() {
    List<Entry> v1 = Arrays.asList(new Entry(0, 44),
      new Entry(3, 5),
      new Entry(8, 7),
      new Entry(11, 3));

    List<Entry> v2 = Arrays.asList(new Entry(3, -1),
      new Entry(11, 5),
      new Entry(16, 5));

    System.out.println("v1: " + multiply(v1, v2));//10
  }

  private void testV2() {
    ListNode a0 = new ListNode(0, 44);
    ListNode a3 = new ListNode(3, 5);
    ListNode a8 = new ListNode(8, 7);
    ListNode a11 = new ListNode(11, 3);

    ListNode b3 = new ListNode(3, -1);
    ListNode b11 = new ListNode(11, 5);
    ListNode b16 = new ListNode(16, 5);

    a0.next = a3;
    a3.next = a8;
    a8.next = a11;

    b3.next = b11;
    b11.next = b16;

    System.out.println("v2: " + new V2().multiply(a0, b3));//10
  }

  public int multiply(List<Entry> v1, List<Entry> v2) {
    int p = 0;

    int i = 0;
    int j = 0;

    while (i < v1.size() && j < v2.size()) {
      Entry a = v1.get(i);
      Entry b = v2.get(j);
      if (a.index == b.index) {
        p += a.value * b.value;

        i++;
        j++;
      } else if (a.index < b.index) {
        i++;
      } else {
        j++;
      }
    }

    return p;
  }

  private static class V2 {

    public int multiply(ListNode v1, ListNode v2) {
      int p = 0;

      while (v1 != null && v2 != null) {
        if (v1.index == v2.index) {
          p += v1.value * v2.value;

          v1 = v1.next;
          v2 = v2.next;
        } else if (v1.index < v2.index) {
          v1 = v1.next;
        } else {
          v2 = v2.next;
        }
      }

      return p;
    }
  }

  private class Entry {

    private int index;
    private int value;

    public Entry(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

  private class ListNode {

    private int index;
    private int value;
    private ListNode next;

    public ListNode() {
    }

    public ListNode(int index) {
      this.index = index;
    }

    public ListNode(int index, int value) {
      this.index = index;
      this.value = value;
    }

    @Override
    public String toString() {
      return "ListNode{" +
        "index=" + index +
        ", value=" + value +
        ", next=" + next +
        '}';
    }
  }

}
