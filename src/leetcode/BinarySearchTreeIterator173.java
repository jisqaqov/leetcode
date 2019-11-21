package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 173. Binary Search Tree Iterator
 * algorithm: Stack, Tree
 * time complexity: O(1)
 * space complexity: O(H)
 * Runtime: 16 ms, faster than 95.60% of Java online submissions for Binary Search Tree Iterator.
 * Memory Usage: 50.2 MB, less than 92.59% of Java online submissions for Binary Search Tree Iterator.
 */
public class BinarySearchTreeIterator173 {

  public static void main(String[] args) {
    BinarySearchTreeIterator173 problem = new BinarySearchTreeIterator173();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(7);
    TreeNode node3 = new TreeNode(3);
    TreeNode node15 = new TreeNode(15);
    TreeNode node9 = new TreeNode(9);
    TreeNode node20 = new TreeNode(20);

    root.left = node3;
    root.right = node15;
    node15.left = node9;
    node15.right = node20;

    BSTIterator iterator = new BSTIterator(root);
    System.out.println(iterator.next());    // return 3
    System.out.println(iterator.next());    // return 7
    System.out.println(iterator.hasNext()); // return true
    System.out.println(iterator.next());    // return 9
    System.out.println(iterator.hasNext()); // return true
    System.out.println(iterator.next());    // return 15
    System.out.println(iterator.hasNext()); // return true
    System.out.println(iterator.next());    // return 20
    System.out.println(iterator.hasNext()); // return false

    System.out.println("v2:");
    BSTIteratorV2 v2 = new BSTIteratorV2(root);
    System.out.println(v2.next());    // return 3
    System.out.println(v2.next());    // return 7
    System.out.println(v2.hasNext()); // return true
    System.out.println(v2.next());    // return 9
    System.out.println(v2.hasNext()); // return true
    System.out.println(v2.next());    // return 15
    System.out.println(v2.hasNext()); // return true
    System.out.println(v2.next());    // return 20
    System.out.println(v2.hasNext()); // return false
  }

  private static class BSTIterator {
    private Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
      leftInorder(root);
    }

    private void leftInorder(TreeNode node) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
      TreeNode node = stack.pop();
      if (node.right != null) {
        leftInorder(node.right);
      }

      return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
      return !stack.isEmpty();
    }
  }

  private static class BSTIteratorV2 {
    private Queue<TreeNode> queue = new LinkedList<>();

    public BSTIteratorV2(TreeNode root) {
      inorder(root);
    }

    private void inorder(TreeNode node) {
      if (node == null) {
        return;
      }

      inorder(node.left);
      queue.add(node);
      inorder(node.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
      return queue.poll().val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
      return !queue.isEmpty();
    }
  }

  /**
   * Definition for a binary tree node.
   */
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


}
