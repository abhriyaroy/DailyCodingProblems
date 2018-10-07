package dcm;

public class day7 {

    /*This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.*/

    public static void main(String args[]) {

        String input = "111";
        int integerInput = Integer.parseInt(input);
        char ch = 'a';
        char dataStore[] = new char[26];
        int i = 0, j = 0;
        for (; i < 26; i++) {
            dataStore[i] = ch;
            ch++;
        }

        int count = 1;
        System.out.println(input);
        int pos = 0;

        while (pos + 1 < input.length()) {
            int a = Integer.parseInt(input.substring(pos, pos + 2));
            if (a > 9 && a < 27) {
                count++;
                System.out.println(a);
            }
            pos++;
        }

        System.out.println("the count is " + count);

    }

}
