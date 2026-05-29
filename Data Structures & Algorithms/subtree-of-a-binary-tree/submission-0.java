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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);

            if(node.val == subRoot.val) return isSameTree(node, subRoot);
        }

        return false;
    }

    public boolean isSameTree(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 != null && r2 == null) return false;
        if(r1 == null && r2 != null) return false;

        if(r1.val != r2.val) return false;

        return isSameTree(r1.left, r2.left) && isSameTree(r1.right, r2.right);
    }
}
