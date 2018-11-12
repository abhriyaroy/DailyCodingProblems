package dcm;

public class day50 {

    /*

    This problem was asked by Microsoft.

Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.

Given the root to such a tree, write a function to evaluate it.

For example, given the following tree:

    *
   / \
  +    +
 / \  / \
3  2  4  5
You should return 45, as it is (3 + 2) * (4 + 5).
     */

    public static void main(String args[]) {
        ExpressionTree expressionTree = new ExpressionTree('*',
                new ExpressionTree('+', new ExpressionTree('3', null, null),
                        new ExpressionTree('2', null, null)),
                new ExpressionTree('+', new ExpressionTree('4', null, null),
                        new ExpressionTree('5', null, null)));

        System.out.println("The result is " + solveExpression(expressionTree));
    }

    private static int solveExpression(ExpressionTree tree) {
        int number = (int) tree.data;
        if (number < 58 && number >= 48) {
            return (number-48);
        }

        switch (tree.data) {
            case '*': {
                return solveExpression(tree.left) * solveExpression(tree.right);
            }
            case '/': {
                return solveExpression(tree.left) / solveExpression(tree.right);
            }
            case '+': {
                return solveExpression(tree.left) + solveExpression(tree.right);
            }
            case '-': {
                return solveExpression(tree.left) - solveExpression(tree.right);
            }
        }
        return 1;
    }
}

class ExpressionTree {
    char data;
    ExpressionTree left = null;
    ExpressionTree right = null;

    ExpressionTree(char data, ExpressionTree left, ExpressionTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
