package dcm.dcp_1_to_10;

public class day8 {

    /*This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1*/

    static int count = 0;

    public static void main(String args[]) {
        UnivalNode tree = new UnivalNode(0,
                new UnivalNode(1, null, null),
                new UnivalNode(0,
                        new UnivalNode(1,
                                new UnivalNode(1, null, null),
                                new UnivalNode(1, null, null)),
                        new UnivalNode(0, null, null)));

        System.out.println(countUnivalSubtrees(tree));
    }

    public static int countUnivalSubtrees(UnivalNode root) {
        if (root == null) {
            return 0;
        }

        countUnival(root);

        return count;
    }


    static int countUnival(UnivalNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int left = countUnival(node.left);
        int right = countUnival(node.right);

        if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {
            count++;
            return node.data;
        } else if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) {
            if (node.data == left || node.data == right) {
                count++;
                return node.data;
            } else return Integer.MIN_VALUE;
        } else {
            if (node.data == left && node.data == right) {
                count++;
                return node.data;
            } else return Integer.MIN_VALUE;
        }


    }
}

class UnivalNode {
    int data;
    UnivalNode left;
    UnivalNode right;

    UnivalNode(int data, UnivalNode left, UnivalNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
