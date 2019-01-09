package dcm.dcp_81_to_90;

public class day86 {

    /*
    Given a string of parentheses, write a function to compute the minimum number of parentheses to be removed to make the string valid (i.e. each open parenthesis is eventually closed).

For example, given the string "()())()", you should return 1. Given the string ")(", you should return 2, since we must remove all of them.
     */

    public static void main(String args[]) {
        System.out.println(fixString("()())()"));
        System.out.println(fixString(")("));
    }

    private static int fixString(String input) {
        int openCount = 0;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            if (currentCharacter == ')' && openCount == 0) {
                count++;
            } else if (currentCharacter == ')' && openCount > 0) {
                openCount--;
            } else {
                openCount++;
            }
        }
        count += openCount;
        return count;
    }
}
