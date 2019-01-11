package dcm.dcp_81_to_90;

public class day89 {

    /*
    Determine whether a tree is a valid binary search tree.

A binary search tree is a tree with two children, left and right, and satisfies the constraint that the key in the left child must be less than or equal to the root and the key in the right child must be greater than or equal to the root.
     */

    public static void main(String args[]) {
        BinaryNode root = new BinaryNode(5);
        root.left = new BinaryNode(4);
        root.right = new BinaryNode(6);
        root.left.left = new BinaryNode(3);
        System.out.println(checkValidity(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static Boolean checkValidity(BinaryNode node, int minData, int maxData) {
        if (node == null)
            return true;
        if (node.data >= maxData || node.data <= minData)
            return false;

        return checkValidity(node.left, minData, node.data) &&
                checkValidity(node.right, node.data, maxData);
    }
}

class BinaryNode {
    int data;
    BinaryNode left;
    BinaryNode right;

    BinaryNode(int data) {
        this.data = data;
    }
}
