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

    private int maxDepthHelper(TreeNode node) {
        if(node == null) { return 0; }
        return Math.max(maxDepthHelper(node.left), maxDepthHelper(node.right)) + 1;
    }

}
