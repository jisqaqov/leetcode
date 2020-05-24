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
 * algorithm: Recursion
 * time complexity:
 * space complexity:
 * Runtime: 1 ms, faster than 95.97% of Java online submissions
 * Memory Usage: 39.5 MB, less than 57.14% of Java online submissions
 */
public class UniqueBinarySearchTreesII95 {

  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }

    return generate(1, n);
  }

  private List<TreeNode> generate(int start, int end) {
    if (start > end) {
      return Collections.singletonList(null);
    }

    List<TreeNode> list = new ArrayList<>();

    for (int val = start; val <= end; val++) {
      List<TreeNode> leftList = generate(start, val - 1);
      List<TreeNode> rightList = generate(val + 1, end);

      for (TreeNode left : leftList) {
        for (TreeNode right : rightList) {
          list.add(new TreeNode(val, left, right));
        }
      }
    }

    return list;
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