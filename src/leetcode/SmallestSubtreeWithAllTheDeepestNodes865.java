package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import sun.reflect.generics.tree.Tree;

/**
 * @author Jandos Iskakov
 * problem: 865. Smallest Subtree with all the Deepest Nodes
 * algorithm: Tree, BFS, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class SmallestSubtreeWithAllTheDeepestNodes865 {

  public static void main(String[] args) {
    SmallestSubtreeWithAllTheDeepestNodes865 problem =
      new SmallestSubtreeWithAllTheDeepestNodes865();
    problem.test1();
    problem.test2();
    problem.test3();
  }

  private void test1() {
    TreeNode root = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node1 = new TreeNode(1);
    TreeNode node6 = new TreeNode(6);
    TreeNode node2 = new TreeNode(2);
    TreeNode node7 = new TreeNode(7);
    TreeNode node4 = new TreeNode(4);
    TreeNode node0 = new TreeNode(0);
    TreeNode node8 = new TreeNode(8);

    root.left = node5;
    root.right = node1;
    node5.left = node6;
    node5.right = node2;
    node2.left = node7;
    node2.right = node4;
    node1.left = node0;
    node1.right = node8;

    System.out.println(subtreeWithAllDeepest(root));//2
  }

  private void test2() {
    TreeNode root = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node3 = new TreeNode(3);
    TreeNode node2 = new TreeNode(2);

    root.left = node1;
    root.right = node3;
    node1.right = node2;

    System.out.println(subtreeWithAllDeepest(root));//2
  }

  private void test3() {
    TreeNode root = new TreeNode(0);
    TreeNode node3 = new TreeNode(3);
    TreeNode node1 = new TreeNode(1);
    TreeNode node4 = new TreeNode(4);
    TreeNode node2 = new TreeNode(2);
    TreeNode node6 = new TreeNode(6);
    TreeNode node5 = new TreeNode(5);

    root.left = node3;
    root.right = node1;
    node3.left = node4;
    node1.left = node2;
    node4.right = node6;
    node2.right = node5;

    System.out.println(subtreeWithAllDeepest(root));//0
  }

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    if (root == null) {
      return null;
    }

    Map<TreeNode, TreeNode> parents = new HashMap<>();
    parents.put(root, null);

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    List<TreeNode> leafs = new ArrayList<>();

    while (!queue.isEmpty()) {
      leafs.clear();
      leafs.addAll(queue);

      for (int sz = queue.size(); sz > 0; sz--) {
        TreeNode node = queue.poll();

        if (node.left != null) {
          parents.put(node.left, node);
          queue.add(node.left);
        }

        if (node.right != null) {
          parents.put(node.right, node);
          queue.add(node.right);
        }
      }
    }

    queue.addAll(leafs);
    Set<TreeNode> used = new HashSet<>();

    while (queue.size() > 1) {
      for (int sz = queue.size(); sz > 0; sz--) {
        TreeNode node = queue.poll();
        TreeNode parent = parents.get(node);

        if (used.contains(parent )) {
          continue;
        }

        used.add(parent);
        queue.add(parent);
      }
    }

    return queue.poll();
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

    @Override
    public String toString() {
      return "TreeNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
    }
  }

}