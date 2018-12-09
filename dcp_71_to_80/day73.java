package dcm.dcp_71_to_80;

public class day73 {
    /*
    This is your coding interview problem for today.

This problem was asked by Google.

Given the head of a singly linked list, reverse it in-place.
     */

    public static void main(String args[]) {
        day73 obj = new day73();
        Node resultantHead = obj.reverse(obj.getLinkedListHead());
        while (resultantHead != null) {
            System.out.println(resultantHead.data);
            resultantHead = resultantHead.next;
        }
    }

    Node getLinkedListHead() {
        return new Node(1, new Node(2, new Node(3, new Node(4))));
    }

    Node reverse(Node head) {
        Node current = head, prev = null, temp;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this(data, null);
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
