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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Queue<List<TreeNode>> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        q.offer(List.of(root));

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            List<TreeNode> nodes = q.poll();
            List<TreeNode> nextLevel = new ArrayList<>();

            for(TreeNode n : nodes){
                level.add(n.val);

                if(n.left != null) nextLevel.add(n.left);
                if(n.right != null) nextLevel.add(n.right);
            }
            
            if(!nextLevel.isEmpty()) q.offer(nextLevel);
            res.add(level);
        }

        return res;
    }
}
