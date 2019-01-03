package dcm.dcp_71_to_80;

public class day80 {

    /*
    Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.

    a
   / \
  b   c
 /
d
     */

    public static void main(String args[]) {
        Node root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('c');
        root.left.left = new Node('d');
        findDeepest(root);
    }

    private static void findDeepest(Node root) {
        Result result = new Result();
        result.depth = -1;
        find(root, 0, result);
        System.out.println(result.depth);
        System.out.println(result.data);
    }

    private static void find(Node current, int level, Result result) {
        if (current != null) {
            find(current.left, ++level, result);
            if (level > result.depth) {
                result.depth = level;
                result.data = current.data;
            }
            find(current.right, level, result);
        }
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

class Result {
    char data;
    int depth;
}
