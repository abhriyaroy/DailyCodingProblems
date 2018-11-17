package dcm.dcp_51_to_60;

import java.util.Stack;

public class day53 {

    /*
    This problem was asked by Apple.

    Implement a queue using two stacks. Recall that a queue is a FIFO (first-in, first-out) data structure with the following methods:
    enqueue, which inserts an element into the queue, and dequeue, which removes it.
     */
    static Stack<Integer> enqueue = new Stack<>();
    static Stack<Integer> dequeue = new Stack<>();

    public static void main(String args[]) {
        push(5);
        push(6);
        push(7);
        push(8);
        System.out.println(pop());
        push(9);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }

    private static void push(int data) {
        enqueue.push(data);
    }

    private static int pop() {
        if (!dequeue.isEmpty()) {
            return dequeue.pop();
        } else {
            if (!enqueue.isEmpty()) {
                while (!enqueue.isEmpty()) {
                    dequeue.push(enqueue.pop());
                }
                return dequeue.pop();
            } else return Integer.MIN_VALUE;
        }
    }
}
