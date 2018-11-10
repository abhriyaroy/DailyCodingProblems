package dcm;

import java.util.ArrayList;

public class day36 {

    /*This problem was asked by Dropbox.

Given the root to a binary search tree, find the second largest node in the tree.*/

    private static ArrayList<Integer> inorderElements = new ArrayList<>();

    public static void main(String args[]) {
        BstNode tree = new BstNode(5, new BstNode(3, new BstNode(2, null, null), new BstNode(4, null, null)), new BstNode(7, null, null));
        findSecondLargest(tree);
    }

    private static void findSecondLargest(BstNode root) {
        inorderTraversal(root);
        System.out.println("The second highest is " + inorderElements.get(inorderElements.size() - 2));
    }

    private static void inorderTraversal(BstNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            inorderElements.add(node.data);
            inorderTraversal(node.right);
        }
    }
}

class BstNode {
    int data;
    BstNode left = null;
    BstNode right = null;

    BstNode(int data, BstNode left, BstNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
