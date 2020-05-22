package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 652. Find Duplicate Subtrees
 * algorithm: DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 17 ms, faster than 79.80%
 * Memory Usage: 41.5 MB, less than 100.00%
 */
public class FindDuplicateSubtrees652 {

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> output = new ArrayList<>();

    helper(root, new HashMap<>(), output, new HashSet<>(), new int[1]);

    return output;
  }

  private int helper(TreeNode root, Map<String, Integer> map, List<TreeNode> output,
    Set<Integer> used, int[] idx) {
    if (root == null) {
      return 0;
    }

    int leftId = helper(root.left, map, output, used, idx);
    int rightId = helper(root.right, map, output, used, idx);

    String code = root.val + ":" + leftId + ":" + rightId;

    int nodeId = 0;
    if (map.containsKey(code)) {
      nodeId = map.get(code);

      if (!used.contains(nodeId)) {
        output.add(root);
      }

      used.add(nodeId);
    } else {
      nodeId = ++idx[0];
      map.put(code, nodeId);
    }

    return nodeId;
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static class V2 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      List<TreeNode> output = new ArrayList<>();

      serialize(root, new HashSet<>(), output, new HashSet<>());

      return output;
    }

    private String serialize(TreeNode root, Set<String> set, List<TreeNode> output, Set<String> used) {
      if (root == null) {
        return "";
      }

      String left = serialize(root.left, set, output, used);
      String right = serialize(root.right, set, output, used);

      String node = root.val + ":" + left + ":" + right;

      if (set.contains(node) && !used.contains(node)) {
        used.add(node);
        output.add(root);
      }

      set.add(node);

      return node;
    }

  }

}