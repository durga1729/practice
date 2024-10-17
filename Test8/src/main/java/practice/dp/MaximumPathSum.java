package practice.dp;

public class MaximumPathSum {
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        maxPathSum(new TreeNode(1));

    }

    public static int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    public static int postOrder(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(postOrder(root.left), 0);
        int right = Math.max(postOrder(root.right), 0);
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
