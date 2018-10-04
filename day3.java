package dcm;

public class day3 {

    /*This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'*/

    public static void main(String args[]) {
        SerializerDeserializer serializerDeserializer = new SerializerDeserializer();
        serializerDeserializer.setRootNode();
        String serializedStr = serializerDeserializer.serializeBinaryTree(serializerDeserializer.rootNode);

        Node.printNode(serializerDeserializer.deserializeBinaryTree(serializedStr).left.left, "root");
    }
}

class Node {
    String data;
    Node left;
    Node right;

    Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    Node(String data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    String getData() {
        return data;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    void setRight(Node right) {
        this.right = right;
    }

    Node getLeft() {
        return left;
    }

    Node getRight() {
        return right;
    }

    static void printNode(Node start, String str) {

        if (start == null)
            return;
        System.out.println(start.getData() + str);
        printNode(start.getLeft(), "left");
        printNode(start.getRight(), "right");
    }
}

class SerializerDeserializer {

    Node rootNode;

    void setRootNode() {
        rootNode = new Node("root", new Node("left", new Node("left.left"), null), new Node("right"));
    }

    String serializeBinaryTree(Node rootNode) {
        if (rootNode == null) {
            return "null,";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(rootNode.getData());
        sb.append(",");

        sb.append(serializeBinaryTree(rootNode.getLeft()));
        sb.append(serializeBinaryTree(rootNode.getRight()));
        return sb.toString();
    }

    Node deserializeBinaryTree(String data) {
        String[] temp = data.split(",");
        return deserialize(temp, 0);
    }

    private Node deserialize(String[] data, int index) {
        if (data[index].equalsIgnoreCase("null")) {
            index++;
            return null;
        }
        Node node = new Node((data[index++]));
        node.setLeft(deserialize(data, index));
        node.setRight(deserialize(data, index));

        return node;
    }
}
