package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * algorithm: Linked List, Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * 
 */
public class ConvertBstToSortedDll426 {

  public static void main(String[] args) {
    ConvertBstToSortedDll426 problem = new ConvertBstToSortedDll426();
    problem.test();
  }

  Node left = null;

  public Node treeToDoublyList(Node root) {
    Node head = new Node();
    treeToDoublyList(root, head);

    head = head.right;
    Node tail = head;
    while (tail.right != null) {
      tail = tail.right;
    }

    head.left = tail;
    tail.right = head;

    return head;
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
  }

  public void treeToDoublyList(Node root, Node leftNode) {
    if (root == null) {
      return;
    }

    treeToDoublyList(root.left, null);

    Node listNode = new Node();
    listNode.val = root.val;
    listNode.left = leftNode;
    leftNode.right = listNode;

    treeToDoublyList(root.right, null);
  }

  /**
   * Definition for a Node.
   */
  class Node {

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
