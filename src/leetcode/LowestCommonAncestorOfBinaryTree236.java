package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 236. Lowest Common Ancestor of a Binary Tree
 * algorithm: Tree, Recursion
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 10 ms, faster than 17.14% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
 * Memory Usage: 36.4 MB, less than 5.55% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
 */
public class LowestCommonAncestorOfBinaryTree236 {

  public static void main(String[] args) {
    LowestCommonAncestorOfBinaryTree236 problem = new LowestCommonAncestorOfBinaryTree236();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node2 = new TreeNode(2);
    TreeNode node7 = new TreeNode(7);
    TreeNode node4 = new TreeNode(4);
    TreeNode node1 = new TreeNode(1);
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

    System.out.println(lowestCommonAncestor(root, root, node5));
    System.out.println(lowestCommonAncestor(root, node5, node1));
    System.out.println(lowestCommonAncestor(root, node5, node4));
    System.out.println(lowestCommonAncestor(root, node7, node6));
    System.out.println(lowestCommonAncestor(root, node7, node4));

    System.out.println("v1:");

    V1 v1 = new V1();
    System.out.println(v1.lowestCommonAncestor(root, root, node5));
    System.out.println(v1.lowestCommonAncestor(root, node5, node1));
    System.out.println(v1.lowestCommonAncestor(root, node5, node4));
    System.out.println(v1.lowestCommonAncestor(root, node7, node6));
    System.out.println(v1.lowestCommonAncestor(root, node7, node4));

    System.out.println("v2:");

    V2 v2 = new V2();
    System.out.println(v2.lowestCommonAncestor(root, root, node5));
    System.out.println(v2.lowestCommonAncestor(root, node5, node1));
    System.out.println(v2.lowestCommonAncestor(root, node5, node4));
    System.out.println(v2.lowestCommonAncestor(root, node7, node6));
    System.out.println(v2.lowestCommonAncestor(root, node7, node4));

    System.out.println("v3:");

    V3 v3 = new V3();
    System.out.println(v3.lowestCommonAncestor(root, root, node5));
    System.out.println(v3.lowestCommonAncestor(root, node5, node1));
    System.out.println(v3.lowestCommonAncestor(root, node5, node4));
    System.out.println(v3.lowestCommonAncestor(root, node7, node6));
    System.out.println(v3.lowestCommonAncestor(root, node7, node4));

    System.out.println("v4:");

    V4 v4 = new V4();
    System.out.println(v4.lowestCommonAncestor(root, root, node5));
    System.out.println(v4.lowestCommonAncestor(root, node5, node1));
    System.out.println(v4.lowestCommonAncestor(root, node5, node4));
    System.out.println(v4.lowestCommonAncestor(root, node7, node6));
    System.out.println(v4.lowestCommonAncestor(root, node7, node4));
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    if (root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) {
      return root;
    } else if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    }

    return null;
  }

  private static class V2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      Map<TreeNode, TreeNode> parents = new HashMap<>();
      parents.put(root, null);

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!parents.containsKey(p) || !parents.containsKey(q)) {
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

      Set<TreeNode> parentOfP = new HashSet<>();

      TreeNode nodeOfP = p;
      while (nodeOfP != null) {
        parentOfP.add(nodeOfP);
        nodeOfP = parents.get(nodeOfP);
      }

      TreeNode nodeOfQ = q;
      while (nodeOfQ != null) {
        if (parentOfP.contains(nodeOfQ)) {
          return nodeOfQ;
        }

        nodeOfQ = parents.get(nodeOfQ);
      }

      return null;
    }

  }

  private static class V1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      List<TreeNode> pParents = getParents(root, p);
      List<TreeNode> qParents = getParents(root, q);

      Set<TreeNode> qParentsSet = new HashSet<>(qParents);
      for (TreeNode parent : pParents) {
        if (qParentsSet.contains(parent)) {
          return parent;
        }
      }

      return null;
    }

    private List<TreeNode> getParents(TreeNode root, TreeNode target) {
      if (root == null) {
        return new ArrayList<>();
      }

      if (root == target) {
        return new ArrayList<>(Collections.singleton(target));
      }

      List<TreeNode> left = getParents(root.left, target);
      if (!left.isEmpty()) {
        left.add(root);
        return left;
      }

      List<TreeNode> right= getParents(root.right, target);
      if (!right.isEmpty()) {
        right.add(root);
        return right;
      }

      return new ArrayList<>();
    }
  }

  private static class V3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      Set<TreeNode> parentsOfP = new HashSet<>();
      Queue<TreeNode> parentsOfQ = new LinkedList<>();

      search(root, p, parentsOfP);
      search(root, q, parentsOfQ);

      parentsOfP.add(root);
      parentsOfQ.add(root);

      while (!parentsOfQ.isEmpty()) {
        TreeNode parent = parentsOfQ.poll();
        if (parentsOfP.contains(parent)) {
          return parent;
        }
      }

      return null;
    }

    private boolean search(TreeNode root, TreeNode target, Collection<TreeNode> deque) {
      if (root == null) {
        return false;
      }

      if (root == target) {
        return true;
      }

      if (search(root.left, target, deque)) {
        deque.add(root.left);
        return true;
      }

      if (search(root.right, target, deque)) {
        deque.add(root.right);
        return true;
      }

      return false;
    }
  }

  private static class V4 {
    private TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      exists(root, p, q);

      return lca;
    }

    public boolean exists(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null) {
        return false;
      }

      int left = exists(root.left, p, q)? 1: 0;
      int right = exists(root.right, p, q)? 1: 0;
      int mid = (root == p || root == q)? 1: 0;


      if (left + mid + right == 2) {
        this.lca = root;
      }

      return left + mid + right >= 1;
    }

  }

  private static class Facebook {

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
        ", left=" + (left != null? left.val: null) +
        ", right=" + (right != null? right.val: null) +
        '}';
    }
  }

}
