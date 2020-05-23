package leetcode.p0013;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Jandos Iskakov
 * problem: 716. Max Stack
 * algorithm: Heap, Linked List
 * time complexity:
 *    push - log(N)
 *    pop - O(N)
 *    popMax - log(N)
 *    top - O(1)
 *    peekMax - O(1)
 * space complexity: O(N)
 * Runtime: 14 ms, faster than 97.21% of Java online submissions
 * Memory Usage: 42.4 MB, less than 100.00% of Java online submissions
 */
public class MaxStack716 {

  public static void main(String[] args) {
    MaxStack716 problem = new MaxStack716();
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
    TreeMap<Integer, List<ListNode>> map;
    ListNode head = null;
    ListNode tail = null;

    /** initialize your data structure here. */
    public MaxStack() {
      map = new TreeMap<>();

      head = new ListNode(0);
      tail = new ListNode(0);

      head.next = tail;
      tail.prev = head;
    }

    public void push(int x) {
      if (!map.containsKey(x)) {
        map.put(x, new ArrayList<>());
      }

      ListNode node = new ListNode(x);

      map.get(x).add(node);

      tail.prev.next = node;

      node.next = tail;
      node.prev = tail.prev;
      tail.prev = node;
    }

    public int pop() {
      int peek = top();

      List<ListNode> list = map.get(peek);
      list.remove(list.size() - 1);

      if (list.isEmpty()) {
        map.remove(peek);
      }

      unlink(tail.prev);

      return peek;
    }

    private void unlink(ListNode node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    public int top() {
      return tail.prev.val;
    }

    public int peekMax() {
      return map.lastKey();
    }

    public int popMax() {
      int max = peekMax();

      List<ListNode> list = map.get(max);
      ListNode node = list.get(list.size() - 1);

      list.remove(list.size() - 1);

      if (list.isEmpty()) {
        map.remove(max);
      }

      unlink(node);

      return node.val;
    }

    class ListNode {
      int val;
      ListNode prev;
      ListNode next;

      public ListNode(int val) {
        this.val = val;
      }
    }
  }

  class MaxStackV2 {
    private Deque<Integer> valStack;
    private Deque<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStackV2() {
      valStack = new ArrayDeque<>();
      maxStack = new ArrayDeque<>();
    }

    public void push(int x) {
      valStack.push(x);

      int max = x;
      if (!maxStack.isEmpty() && maxStack.peek() > x) {
        max = maxStack.peek();
      }

      maxStack.push(max);
    }

    public int pop() {
      maxStack.pop();
      return valStack.pop();
    }

    public int top() {
      return valStack.peek();
    }

    public int peekMax() {
      return maxStack.peek();
    }

    public int popMax() {
      int max = maxStack.peek();

      Deque<Integer> temp = new ArrayDeque<>();

      while (valStack.peek() != max) {
        maxStack.pop();
        temp.push(valStack.pop());
      }

      valStack.pop();
      maxStack.pop();

      while (!temp.isEmpty()) {
        push(temp.pop());
      }

      return max;
    }
  }

}