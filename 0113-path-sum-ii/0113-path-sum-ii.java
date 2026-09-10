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
    boolean flag = false;
    List<List<Integer>> answerList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> inList  = new ArrayList<>();
        function(root, targetSum, inList);
        return answerList;
    }

    public void function(TreeNode root, int t, List<Integer> inList) {
        if(root == null) return;
        if(root.left == null && root.right == null && t - root.val == 0) {
            inList.add(root.val);
            answerList.add(new ArrayList<>(inList));
            inList.remove(inList.size() - 1);
            return;
        }
        inList.add(root.val);
        t = t - root.val;
        function(root.left, t, inList);
        function(root.right, t, inList);
        inList.remove(inList.size() - 1);
        return;
    }
}