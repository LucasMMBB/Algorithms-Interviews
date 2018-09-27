/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    // top bottom solution
    // time: O(N^2)
    public boolean isBalanced(TreeNode root) {
        if(root == null){ return true; }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int maxDepth(TreeNode node) {
        if(node == null) { return 0; }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    // bottom top solution
    // time: O(N)
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    public int dfsHeight(TreeNode node) {
        if (node == null) { return 0; }
        int leftHeight = dfsHeight(node.left);
        if (leftHeight == -1) { return -1; }
        int rightHeight = dfsHeight(node.right);
        if (rightHeight == -1) { return -1; }

        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;
    }
}