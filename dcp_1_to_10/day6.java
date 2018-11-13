package dcm.dcp_1_to_10;

abstract public class day6 {

    /*This problem was asked by Google.

A XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node. Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.

If using a language that has no pointers (such as Python), you can assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses.*/

    public static void main(String args[]) {
        day6 abc = new day6() {
            @Override
            XorNode getPointer() {
                return null;
            }

            @Override
            XorNode dereferencePointer() {
                return null;
            }
        };

        XorNode list = new XorNode(5, abc.getPointer());
    }

    abstract XorNode getPointer();

    abstract XorNode dereferencePointer();
}

class XorNode {
    int data;
    XorNode ptr;

    XorNode(int data, XorNode ptr) {
        this.data = data;
        this.ptr = ptr;
    }
}
