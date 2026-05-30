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
    public int kthSmallest(TreeNode root, int k) {
        var list = inOrderTravesal(root, new ArrayList<>());
        return list.get(k - 1);
    }

    private List<Integer> inOrderTravesal(TreeNode root, List<Integer> res){
        if(root == null) return res;

        inOrderTravesal(root.left, res);
        res.add(root.val);
        inOrderTravesal(root.right, res);

        return res;
    }
}
