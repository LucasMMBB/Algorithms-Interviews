package com.practiceproblems.amazon;

import java.util.Arrays;
import java.util.List;

public class OA_10_24_2018_4 {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public int findTreeNodeDistance(List<Integer> list, Node node1, Node node2) {
        Node root = buildBST(list);

        Node lca = findLCA(root, node1, node2);

        int depth1 = getDepth(lca, node1);
        int depth2 = getDepth(lca, node2);

        return depth1 + depth2;
    }

    private int getDepth(Node root, Node node) {
        if (root == null) return 0;

        if (node.val < root.val) {
            return getDepth(root.left, node) + 1;
        } else if (node.val > root.val) {
            return getDepth(root.right, node) + 1;
        } else {
            return 0;
        }
    }

    private Node findLCA(Node root, Node node1, Node node2) {
        if (node1.val > node2.val) {
            return findLCA(root, node2, node1);
        }

        if (node2.val < root.val) {
            return findLCA(root.left, node1, node2);
        } else if (node1.val > root.val) {
            return findLCA(root.right, node1, node2);
        } else {
            return root;
        }
    }

    private Node buildBST(List<Integer> list) {
        Node root = new Node(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            insertNode(root, list.get(i));
        }
        return root;
    }

    private void insertNode(Node root, int val) {
        if (val < root.val) {
            if (root.left == null) {
                root.left = new Node(val);
            } else {
                insertNode(root.left, val);
            }
        } else if (val > root.val) {
            if (root.right == null) {
                root.right = new Node(val);
            } else {
                insertNode(root.right, val);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(5,6,3,1,2,4,7,9);
        Node node1 = new Node(2);
        Node node2 = new Node(4);

        OA_10_24_2018_4 solution = new OA_10_24_2018_4();
        System.out.println(solution.findTreeNodeDistance(input, node1, node2));
    }
}
