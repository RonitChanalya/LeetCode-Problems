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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        int n = 0;
        function(root, n);
        return sum;
    }

    public void function(TreeNode root, int n) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            n = n + root.val;
            sum = sum + n;
            return;
        }
        n = (n + root.val) * 10;
        function(root.left, n);
        function(root.right, n);
        return;
    }
}