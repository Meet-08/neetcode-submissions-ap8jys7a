/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        Map<TreeNode, Integer> dp = new HashMap<>();
        int diff = Math.abs(height(root.left, dp) - height(root.right, dp));

        if(diff > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root, Map<TreeNode, Integer> dp){
        if(root == null) return 0;

        if(dp.containsKey(root)) return dp.get(root);

        int leftHeight = height(root.left, dp);
        int rightHeight = height(root.right, dp);

        dp.put(root.left, leftHeight);
        dp.put(root.right, rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
