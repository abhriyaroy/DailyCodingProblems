package dcm;

import java.util.HashMap;

public class day13 {

    /*This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb"*/


    public static void main(String[] args) {
        String input = "abcccca";
        int k = 2, length = input.length();
        HashMap<Character, Integer> checker = new HashMap<>();
        int charCount = 0, left = 0, right = 0, largestLeft = 0, largestRight = 0;
        int newCharacterAnchor = 0, previousNewCharacterAnchor = 0;

        for (; right < length; right++) {
            char currentChar = input.charAt(right);
            if (!checker.containsKey(currentChar)) {
                charCount++;
                if (charCount > k) {
                    charCount--;
                    if ((largestRight - largestLeft) < (right-1 - left)) {
                        largestLeft = left;
                        largestRight = right - 1;
                    }
                    left = newCharacterAnchor;
                    checker.remove(input.charAt(previousNewCharacterAnchor));
                }
                checker.put(currentChar, 1);
            }

            if (right > 0) {
                if (input.charAt(right) != input.charAt(right - 1)) {
                    previousNewCharacterAnchor = newCharacterAnchor;
                    newCharacterAnchor = right;
                }
            }
        }
        if ((largestRight - largestLeft) < (right-1 - left)) {
            largestLeft = left;
            largestRight = right - 1;
        }

        System.out.println(input.substring(largestLeft, largestRight+1));
    }
}
