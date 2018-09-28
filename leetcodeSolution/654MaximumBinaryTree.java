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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums, int s, int e) {
        if(s > e){ return null; }
        int p = findMaxPos(nums, s, e);
        TreeNode root = new TreeNode(nums[p]);
        root.left = constructMaximumBinaryTree(nums, s, p - 1);
        root.right = constructMaximumBinaryTree(nums, p + 1, e);
        return root;
    }
    
    public int findMaxPos(int[] nums, int s, int e) {
        int p = s;
        int max = nums[s];
        for(int i = s + 1; i <= e; i++) {
            if(nums[i] > max){
                p = i;
                max= nums[i];
            }
        }
        return p;
    }
}