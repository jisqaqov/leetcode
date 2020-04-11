package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
 * A binary tree and a number k are given. Print every path in the tree with sum of the nodes in the
 * path as k. A path can start from any node and end at any node and must be downward only,
 * i.e. they need not be root node and leaf node; and negative numbers can also be there in the tree.
 *
 * Examples:
 *
 * Input : k = 5
 *         Root of below binary tree:
 *            1
 *         /     \
 *       3        -1
 *     /   \     /   \
 *    2     1   4     5
 *         /   / \     \
 *        1   1   2     6
 *
 * Output :
 * 3 2
 * 3 1 1
 * 1 3 1
 * 4 1
 * 1 -1 4 1
 * -1 4 2
 * 5
 * 1 -1 5
 *
 * algorithm: Hash Table, Prefix Sum
 * time complexity:
 * space complexity:
 */
public class PrintAllKSumPathsInBinaryTree {

  public static void main(String[] args) {
    PrintAllKSumPathsInBinaryTree problem = new PrintAllKSumPathsInBinaryTree();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(1);
    TreeNode node3 = new TreeNode(3);
    TreeNode node2 = new TreeNode(2);
    TreeNode node1 = new TreeNode(1);
    TreeNode node1_2 = new TreeNode(1);
    TreeNode nodeM1 = new TreeNode(-1);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node1_3 = new TreeNode(1);
    TreeNode node2_2 = new TreeNode(2);
    TreeNode node6 = new TreeNode(6);

    root.left = node3;
    root.right = nodeM1;
    node3.left = node2;
    node3.right = node1;
    node1.left = node1_2;

    nodeM1.left = node4;
    nodeM1.right = node5;
    node4.left = node1_3;
    node4.right = node2_2;
    node5.right = node6;

    System.out.println(printKSumPath(root, 5));
  }

  private List<String> printKSumPath(TreeNode root, int k) {
    List<String> output = new ArrayList<>();

    Map<Integer, List<Integer>> map = new HashMap<>();
    map.put(0, new ArrayList<>(Collections.singletonList(0)));

    helper(root, 0, new ArrayList<>(), k, map, output);

    return output;
  }

  private void helper(TreeNode root, int prefix, List<Integer> path, int k,
    Map<Integer, List<Integer>> map, List<String> output) {
    if (root == null) {
      return;
    }

    prefix += root.val;

    path.add(root.val);

    if (map.containsKey(prefix - k)) {
      for (int size : map.get(prefix - k)) {
        output.add(printPath(path.subList(size, path.size())));
      }
    }

    map.putIfAbsent(prefix, new ArrayList<>());
    map.get(prefix).add(path.size());

    helper(root.left, prefix, path, k, map, output);
    helper(root.right, prefix, path, k, map, output);

    map.get(prefix).remove(map.get(prefix).size() - 1);
    path.remove(path.size() - 1);
  }

  private String printPath(List<Integer> output) {
    StringBuilder sb = new StringBuilder();

    for (int val : output) {
      if (sb.length() > 0) {
        sb.append("->");
      }

      sb.append(val);
    }

    return sb.toString();
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