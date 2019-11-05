package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * algorithm: Linked List, Tree, Stack
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.
 * Memory Usage: 38.5 MB, less than 6.90% of Java online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.
 */
public class ConvertBstToSortedDll426 {

  public static void main(String[] args) {
    ConvertBstToSortedDll426 problem = new ConvertBstToSortedDll426();
    problem.test();
  }

  private void test() {
    Node root = new Node(4, null, null);
    Node node2 = new Node(2, null, null);
    Node node5 = new Node(5, null, null);
    Node node1 = new Node(1, null, null);
    Node node3 = new Node(3, null, null);

    root.left = node2;
    root.right = node5;
    node2.left = node1;
    node2.right = node3;

    System.out.println(treeToDoublyList(root));
    System.out.println(new RecursiveVersion().treeToDoublyList(root));
  }

  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }

    Deque<Node> deque = new ArrayDeque<>();
    Node node = root;

    Node head = null;
    Node prev = null;

    while (node != null || !deque.isEmpty()) {
      while (node != null) {
        deque.push(node);
        node = node.left;
      }

      node = deque.pop();

      Node listNode = new Node();
      listNode.val = node.val;
      listNode.left = prev;

      if (prev != null) {
        prev.right = listNode;
      }

      if (head == null) {
        head = listNode;
      }

      prev = listNode;

      node = node.right;
    }

    Node tail = prev;
    head.left = tail;
    tail.right = head;

    return head;
  }

  private static class RecursiveVersion {
    private Node left = null;
    private Node head = null;

    public Node treeToDoublyList(Node root) {
      head = null;
      left = null;

      inOrderTraverse(root);

      Node tail = head;
      while (tail.right != null) {
        tail.right.left = tail;
        tail = tail.right;
      }

      head.left = tail;
      tail.right = head;

      return head;
    }

    private void inOrderTraverse(Node root) {
      if (root == null) {
        return;
      }

      inOrderTraverse(root.left);

      Node listNode = new Node();
      listNode.val = root.val;

      if (left != null) {
        left.right = listNode;
      }

      if (head == null) {
        head = listNode;
      }

      left = listNode;

      inOrderTraverse(root.right);
    }
  }

  /**
   * Definition for a Node.
   */
  public static class Node {

    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    @Override
    public String toString() {
      return "Node{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
    }
  }

}
