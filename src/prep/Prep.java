package prep;

import java.util.PriorityQueue;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    MaxStack stack = new MaxStack();
    stack.push(5);
    stack.push(1);
    stack.push(5);

    System.out.println(stack.top());//5
    System.out.println(stack.popMax());//5
    System.out.println(stack.top());//1
    System.out.println(stack.peekMax());//5
    System.out.println(stack.pop());//1
    System.out.println(stack.top());//5
  }

  class MaxStack {
    int idx = 0;
    ListNode head = null;
    ListNode tail = null;
    PriorityQueue<ListNode> pq;

    /** initialize your data structure here. */
    public MaxStack() {
      head = new ListNode();

      tail = head;

      pq = new PriorityQueue<>(
        (a, b) -> b.val == a.val? b.index - a.index: b.val - a.val);
    }

    public void push(int x) {
      ListNode node = new ListNode(x, idx++);

      tail.next = node;
      node.prev = tail;

      tail = node;

      pq.add(node);
    }

    public int pop() {
      int val = tail.val;

      pq.remove(tail);

      if (tail.prev != null) {
        tail.prev.next = null;
      }

      tail = tail.prev;

      return val;
    }

    public int top() {
      return tail.val;
    }

    public int peekMax() {
      return pq.peek().val;
    }

    public int popMax() {
      ListNode node = pq.poll();

      if (node.val == tail.val) {
        pop();

        return node.val;
      }

      node.prev.next = node.next;
      if (node.next != null) {
        node.next.prev = node.prev;
      }

      return node.val;
    }

    class ListNode {
      int index = 0;
      int val;
      ListNode prev;
      ListNode next;

      ListNode() {
      }

      ListNode(int val, int index) {
        this.val = val;
        this.index = index;
      }
    }

  }

}