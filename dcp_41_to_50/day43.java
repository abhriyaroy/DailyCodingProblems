package dcm.dcp_41_to_50;

import java.util.ArrayList;

public class day43 {

    /*This problem was asked by Amazon.

Implement a stack that has the following methods:

push(val), which pushes an element onto the stack
pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
Each method should run in constant time*/
    ArrayList<StackStruct> stack = new ArrayList<StackStruct>();
    int top = -1;

    public static void main(String args[]) {
        day43 object = new day43();
        try {
            object.push(2);
            object.push(4);
            object.push(1);
            object.push(5);
            System.out.println(object.max());
            object.pop();
            System.out.println(object.max());
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private int pop() throws Exception {
        if (top >= 0) {
            return stack.get(top--).data;
        } else {
            throw new Exception();
        }
    }

    private void push(int data) {
        top++;
        stack.add(new StackStruct());
        stack.get(top).data = data;
        if (top == 0) {
            stack.get(top).max = Integer.max(data, stack.get(top).max);
        } else {
            stack.get(top).max = Integer.max(data, stack.get(top - 1).max);
        }
    }

    private int max() {
        return stack.get(top).max;
    }


}

class StackStruct {
    int data;
    int max = Integer.MIN_VALUE;
}
