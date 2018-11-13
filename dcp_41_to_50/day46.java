package dcm.dcp_41_to_50;

public class day46 {

    /*This problem was asked by Amazon.

Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum length, return any one.

For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana".*/

    private static void longestPalindromicSubstring(String string) {
        int n = string.length();
        boolean recordTable[][] = new boolean[n][n];
        int startPos = 0, maxLength = 0;

        for (int i = 0; i < n; i++) {
            recordTable[i][i] = true;
            startPos = i;
            maxLength = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            if (string.charAt(i) == string.charAt(i + 1)) {
                recordTable[i][i + 1] = true;
                startPos = i;
                maxLength = 2;
            }
        }

        for (int j = 3; j <= n; j++) {
            for (int i = 0; i < n - j + 1; i++) {
                int k = i + j - 1;
                if (recordTable[i + 1][k - 1] && string.charAt(i) == string.charAt(k)) {
                    recordTable[i][k] = true;
                    if (j > maxLength) {
                        maxLength = j;
                        startPos = i;
                    }
                }
            }
        }
        System.out.println("Longest substring is " + string.substring(startPos, startPos + maxLength));
    }

    public static void main(String args[]){
        longestPalindromicSubstring("aabcdcb");
        longestPalindromicSubstring("bananas");
    }
}
