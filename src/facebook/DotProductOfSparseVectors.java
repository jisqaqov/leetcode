package facebook;

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
  }

  private void test() {
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

    System.out.println(multiply(a0, b3));//10
  }

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
