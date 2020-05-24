package leetcode.p0020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 95. Unique Binary Search Trees II
 * algorithm: DP
 * time complexity:
 * space complexity:
 * Runtime: 1 ms, faster than 95.97% of Java online submissions
 * Memory Usage: 39.5 MB, less than 57.14% of Java online submissions
 */
public class UniqueBinarySearchTreesII95 {

  public List<TreeNode> generateTrees(int n) {
    Map<Integer, List<TreeNode>> dp = new HashMap<>();

    dp.put(0, Collections.emptyList());
    dp.put(1, Arrays.asList(new TreeNode(1)));

    for (int i = 2; i <= n; i++) {
      dp.put(i, generate(i, dp));
    }

    return dp.get(n);
  }

  private List<TreeNode> generate(int n, Map<Integer, List<TreeNode>> dp) {
    List<TreeNode> list = new ArrayList<>();

    for (int k = 1; k <= n; k++) {
      List<TreeNode> left = cloneTrees(dp.get(k - 1), 0);
      List<TreeNode> right = cloneTrees(dp.get(n - k), k);

      list.addAll(buildTrees(left, right, k));
    }

    return list;
  }

  private List<TreeNode> buildTrees(List<TreeNode> leftList, List<TreeNode> rightList, int k) {
    List<TreeNode> list = new ArrayList<>();

    if (rightList.isEmpty()) {
      for (TreeNode left : leftList) {
        list.add(new TreeNode(k, left, null));
      }
    } else if (leftList.isEmpty()) {
      for (TreeNode right : rightList) {
        list.add(new TreeNode(k, null, right));
      }
    }

    for (TreeNode left : leftList) {
      for (TreeNode right : rightList) {
        list.add(new TreeNode(k, left, right));
      }
    }

    return list;
  }

  private List<TreeNode> cloneTrees(List<TreeNode> list, int inc) {
    List<TreeNode> clones = new ArrayList<>();
    for (TreeNode root : list) {
      clones.add(cloneTree(root, inc));
    }

    return clones;
  }

  private TreeNode cloneTree(TreeNode root, int inc) {
    if (root == null) {
      return null;
    }

    TreeNode clone = new TreeNode(root.val + inc);
    clone.left = cloneTree(root.left, inc);
    clone.right = cloneTree(root.right, inc);

    return clone;
  }

  private class TopDownVersion {

    public List<TreeNode> generateTrees(int n) {
      Map<Integer, List<TreeNode>> dp = new HashMap<>();

      dp.put(0, Collections.emptyList());
      dp.put(1, Arrays.asList(new TreeNode(1)));

      return generate(n, dp);
    }

    private List<TreeNode> generate(int n, Map<Integer, List<TreeNode>> dp) {
      if (dp.containsKey(n)) {
        return dp.get(n);
      }

      List<TreeNode> list = new ArrayList<>();

      for (int k = 1; k <= n; k++) {
        List<TreeNode> left = cloneTrees(generate(k - 1, dp), 0);
        List<TreeNode> right = cloneTrees(generate(n - k, dp), k);

        list.addAll(buildTrees(left, right, k));
      }

      return list;
    }

    private List<TreeNode> buildTrees(List<TreeNode> leftList, List<TreeNode> rightList, int k) {
      List<TreeNode> list = new ArrayList<>();

      if (rightList.isEmpty()) {
        for (TreeNode left : leftList) {
          list.add(new TreeNode(k, left, null));
        }
      } else if (leftList.isEmpty()) {
        for (TreeNode right : rightList) {
          list.add(new TreeNode(k, null, right));
        }
      }

      for (TreeNode left : leftList) {
        for (TreeNode right : rightList) {
          list.add(new TreeNode(k, left, right));
        }
      }

      return list;
    }

    private List<TreeNode> cloneTrees(List<TreeNode> list, int inc) {
      List<TreeNode> clones = new ArrayList<>();
      for (TreeNode root : list) {
        clones.add(cloneTree(root, inc));
      }

      return clones;
    }

    private TreeNode cloneTree(TreeNode root, int inc) {
      if (root == null) {
        return null;
      }

      TreeNode clone = new TreeNode(root.val + inc);
      clone.left = cloneTree(root.left, inc);
      clone.right = cloneTree(root.right, inc);

      return clone;
    }

  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }


}