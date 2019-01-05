package dcm.dcp_81_to_90;

public class day83 {

    /*
    Invert a binary tree.

For example, given the following tree:

    a
   / \
  b   c
 / \  /
d   e f
should become:

  a
 / \
 c  b
 \  / \
  f e  d
     */

    public static void main(String args[]) {
        Node root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('c');
        root.left.left = new Node('d');
        root.left.right = new Node('e');
        root.right.left = new Node('f');

        invert(root);
    }

    private static void invert(Node root) {
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        System.out.println(root.data);
        if (root.left != null)
            invert(root.left);
        if (root.right != null)
            invert(root.right);
    }
}

class Node {
    char data;
    Node left = null;
    Node right = null;

    Node(char data) {
        this.data = data;
    }
}
