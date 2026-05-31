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
    int preIdx = 0;
    Map<Integer, Integer> inIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inIndex.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int l, int r) {
        if (l > r)
            return null;

        TreeNode root = new TreeNode(preorder[preIdx++]);

        int mid = inIndex.get(root.val);

        root.left = buildTree(preorder, inorder, l, mid - 1);
        root.right = buildTree(preorder, inorder, mid + 1, r);

        return root;
    }
}
