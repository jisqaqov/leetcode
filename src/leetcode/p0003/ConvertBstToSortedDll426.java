package leetcode.p0003;

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

    treeToDoublyList(root);
    System.out.println(new RecursiveVersion().treeToDoublyList(root));
  }

  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }

    Deque<Node> deque = new ArrayDeque<>();
    Node node = root;

    Node head = null;
    Node tail = null;

    while (node != null || !deque.isEmpty()) {
      while (node != null) {
        deque.push(node);
        node = node.left;
      }

      node = deque.pop();

      if (head == null) {
        head = node;
      } else {
        tail.right = node;
        node.left = tail;
      }

      tail = node;

      node = node.right;
    }

    head.left = tail;
    tail.right = head;

    return head;
  }

  private static class RecursiveVersion {
    private Node tail = null;
    private Node head = null;

    public Node treeToDoublyList(Node root) {
      if (root == null) {
        return null;
      }

      head = null;
      tail = null;

      inorder(root);

      head.left = tail;
      tail.right = head;

      return head;
    }

    private void inorder(Node root) {
      if (root == null) {
        return;
      }

      inorder(root.left);

      if (head == null) {
        head = root;
      } else {
        tail.right = root;
        root.left = tail;
      }

      tail = root;

      inorder(root.right);
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
