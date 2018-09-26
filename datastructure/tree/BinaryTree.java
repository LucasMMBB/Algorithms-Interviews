/**
 * Binary tree class
 *
 * @author maoxul
 * @date 9/25/2018
 */
public class BinaryTree {
    private TreeNode root;

    public BinaryTree(int value) {
        root = new TreeNode(value);
    }

    public int maxDepth(){
        TreeNode node = root;
        return maxDepthHelper(node);
    }

    public int childrenNum() {
        TreeNode node = root;
        return childrenNumHelper(node);
    }

    private int childrenNumHelper(TreeNode node) {
        if (node == null) { return 0; }
        int left = childrenNumHelper(node.left);
        int right = childrenNumHelper(node.right);
        return left + right + 1;
    }

    private int maxDepthHelper(TreeNode node) {
        if(node == null) { return 0; }
        return Math.max(maxDepthHelper(node.left), maxDepthHelper(node.right)) + 1;
    }

}
