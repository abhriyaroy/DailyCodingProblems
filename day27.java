package dcm;

import java.util.Stack;

public class day27 {

    /*This problem was asked by Facebook.

Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.*/

    public static void main(String args[]) {
        String input = "([])[]({})";

        Stack<Character> stack = new Stack<>();
        Character openingFirst = '(';
        Character closingFirst = ')';
        Character openingSecond = '{';
        Character closingSecond = '}';
        Character openingThird = '[';
        Character closingThird = ']';
        int length = input.length();
        boolean balanced = true;

        for (int i = 0; i < length; i++) {
            Character character = input.charAt(i);
            if (character == openingFirst || character == openingSecond || character == openingThird) {
                stack.push(character);
            } else if (character == closingFirst) {
                if (stack.peek() != openingFirst) {
                    balanced = false;
                    break;
                }
                stack.pop();
            } else if (character == closingSecond) {
                if (stack.peek() != openingSecond) {
                    balanced = false;
                    break;
                }
                stack.pop();
            } else if (character == closingThird) {
                if (stack.peek() != openingThird) {
                    balanced = false;
                    break;
                }
                stack.pop();
            }
        }
        if (balanced && stack.isEmpty()){
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }

}
