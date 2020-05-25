package leetcode.p0001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 894. All Possible Full Binary Trees
 * algorithm: Tree, Recursion, Memoization
 * time complexity:
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 99.56%
 * Memory Usage: 41.5 MB, less than 100.00%
 */
public class AllPossibleFullBinaryTrees894 {

  private Map<Integer, List<TreeNode>> dp = new HashMap<>();

  public List<TreeNode> allPossibleFBT(int n) {
    if (n % 2 == 0) {
      return Collections.emptyList();
    }

    if (dp.containsKey(n)) {
      return dp.get(n);
    }

    if (n == 1) {
      return Collections.singletonList(new TreeNode(0));
    }

    List<TreeNode> list = new ArrayList<>();

    for (int k = 1; k < n; k += 2) {
      List<TreeNode> leftList = allPossibleFBT(k);
      List<TreeNode> rightList = allPossibleFBT(n - k - 1);

      for (TreeNode left : leftList) {
        for (TreeNode right : rightList) {
          list.add(new TreeNode(0, left, right));
        }
      }
    }

    dp.put(n, list);

    return list;
  }

  private class IterativeVersion {

    public List<TreeNode> allPossibleFBT(int n) {
      if (n % 2 == 0) {
        return Collections.emptyList();
      }

      Map<Integer, List<TreeNode>> dp = new HashMap<>();
      dp.put(1, Collections.singletonList(new TreeNode(0)));

      for (int k = 3; k <= n; k += 2) {
        dp.put(k, helper(k, dp));
      }

      return dp.get(n);
    }

    private List<TreeNode> helper(int n, Map<Integer, List<TreeNode>> dp) {
      List<TreeNode> list = new ArrayList<>();

      for (int g = 1; g < n; g += 2) {
        for (TreeNode left : dp.get(g)) {
          for (TreeNode right : dp.get(n - g - 1)) {
            list.add(new TreeNode(0, left, right));
          }
        }
      }

      return list;
    }

  }

  /**
   * Definition for a binary tree node.
   **/
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