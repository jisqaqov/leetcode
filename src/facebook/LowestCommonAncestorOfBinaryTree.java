package facebook;

/**
 * The closest common ancestor in a tree forest.
 * variation of https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * private class TreeNode {
 *   private String val;
 *   private TreeNode parent;
 *   private TreeNode left;
 *   private TreeNode right;
 * }
 * Constrains: O(1) additional memory
 */
public class LowestCommonAncestorOfBinaryTree {

  public static void main(String[] args) {
    LowestCommonAncestorOfBinaryTree problem = new LowestCommonAncestorOfBinaryTree();
    problem.test();
  }

  private void test() {
    TreeNode a = new TreeNode("a");
    TreeNode b = new TreeNode("b", a);
    TreeNode c = new TreeNode("c", a);
    TreeNode d = new TreeNode("d", b);
    TreeNode e = new TreeNode("e", c);
    TreeNode f = new TreeNode("f", c);
    TreeNode i = new TreeNode("i", d);
    TreeNode j = new TreeNode("j", d);
    TreeNode l = new TreeNode("l", i);
    TreeNode k = new TreeNode("k", i);
    TreeNode h = new TreeNode("h", e);
    TreeNode g = new TreeNode("g", e);

    a.left = b;
    a.right = c;
    b.left = d;
    c.left = e;
    c.right = f;
    e.left = h;
    e.right = g;
    d.left = i;
    d.right = j;
    i.left = l;
    i.right = k;

    System.out.println(closesCommonAncestor(h, f));//c
    System.out.println(closesCommonAncestor(f, h));//c
    System.out.println(closesCommonAncestor(h, e));//e
    System.out.println(closesCommonAncestor(d, h));//a
    System.out.println(closesCommonAncestor(b, l));//b
    System.out.println(closesCommonAncestor(l, b));//b
    System.out.println(closesCommonAncestor(e, a));//a
    System.out.println(closesCommonAncestor(c, d));//a
    System.out.println(closesCommonAncestor(i, j));//d
    System.out.println(closesCommonAncestor(e, k));//a
    System.out.println(closesCommonAncestor(g, e));//e
    System.out.println(closesCommonAncestor(e, g));//e
  }

  public TreeNode closesCommonAncestor(TreeNode node1, TreeNode node2) {
    int height1 = getHeight(node1);
    int height2 = getHeight(node2);

    if (height2 > height1) {
      while (height2 > height1) {
        node2 = node2.parent;
        height2--;
      }
    } else if (height1 > height2) {
      while (height1 > height2) {
        node1 = node1.parent;
        height1--;
      }
    }

    while (!node1.equals(node2)) {
      node1 = node1.parent;
      node2 = node2.parent;
    }

    return node1;
  }

  private int getHeight(TreeNode node) {
    int height = 1;

    TreeNode temp = node;
    while (temp.parent != null) {
      temp = temp.parent;
      height++;
    }

    return height;
  }

  private class TreeNode {

    private String val;
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(String val) {
      this.val = val;
    }

    public TreeNode(String val, TreeNode parent) {
      this.val = val;
      this.parent = parent;
    }

    @Override
    public String toString() {
      return "TreeNode{" +
        "val='" + val + '\'' +
        '}';
    }
  }

}
