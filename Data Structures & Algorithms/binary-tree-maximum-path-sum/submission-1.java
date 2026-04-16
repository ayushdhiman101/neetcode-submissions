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

    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxPathSum2(root);
        return ans;
        
    }
    public int maxPathSum2(TreeNode root) {
        if(root == null) return 0;
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);

        int sum1 = left + right + root.val;
        int sum2 = Math.max(left, right) + root.val;
        int sum3 = root.val;

        ans = Math.max(ans, Math.max(sum1, Math.max(sum2, sum3)));

        return Math.max(Math.max(left, right) + root.val, root.val);
        
    }
}
