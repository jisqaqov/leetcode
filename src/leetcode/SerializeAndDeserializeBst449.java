package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 449. Serialize and Deserialize BST
 * algorithm: Tree
 * time complexity:
 * space complexity:
 */
public class SerializeAndDeserializeBst449 {

    public static void main(String[] args) {
        SerializeAndDeserializeBst449 solution = new SerializeAndDeserializeBst449();
        solution.test();
    }

    public void test() {
        TreeNode root = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node30 = new TreeNode(30);
        TreeNode node20 = new TreeNode(20);
        TreeNode node25 = new TreeNode(25);
        TreeNode node16 = new TreeNode(16);
        TreeNode node12 = new TreeNode(12);
        TreeNode node17 = new TreeNode(17);
        TreeNode node37 = new TreeNode(37);
        TreeNode node34 = new TreeNode(34);
        TreeNode node40 = new TreeNode(40);

        root.left = node6;
        root.right = node30;
        node6.left = node4;
        node6.right = node8;
        node8.left = node7;
        node8.right = node9;
        node30.left = node20;
        node30.right = node37;
        node20.left = node16;
        node20.right = node25;
        node16.left = node12;
        node16.right = node17;
        node37.left = node34;
        node37.right = node40;

        System.out.println(serialize(root));
        System.out.println(deserialize(serialize(root)));
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        serialize(root, sb);

        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        if (sb.length() > 0) {
            sb.append(";");
        }

        sb.append(root.val);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        String[] values = data.split(";");

        Map<TreeNode, Info> map = new HashMap<>();

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Info info = new Info(root, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
        map.put(root, info);

        for (int i = 1; i < values.length; i++) {
            int val = Integer.parseInt(values[i]);

            TreeNode newNode = new TreeNode(val);
            Info newInfo = new Info(newNode);

            map.put(newNode, newInfo);

            if (info.inRange(val)) {
                info.addChild(newInfo);
            } else {
                info = map.get(info.parent);
                while (!info.inRange(val)) {
                    info = map.get(info.parent);
                }

                info.addChild(newInfo);
            }

            info = newInfo;
        }

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private class Info {
        TreeNode node;
        TreeNode parent;
        int min, max;

        Info(TreeNode node) {
            this.node = node;
        }

        Info(TreeNode node, TreeNode parent, int min, int max) {
            this.node = node;
            this.parent = parent;
            this.min = min;
            this.max = max;
        }

        boolean inRange(int val) {
            return val >= min && val <= max;
        }

        void addChild(Info info) {
            info.parent = node;

            if (info.node.val >= node.val) {
                node.right = info.node;
                info.max = max;
                info.min = node.val;
            } else {
                node.left = info.node;
                info.max = node.val;
                info.min = min;
            }
        }
    }

}
