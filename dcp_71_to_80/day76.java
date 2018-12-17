package dcm.dcp_71_to_80;

public class day76 {

    /*
    You are given an N by M 2D matrix of lowercase letters. Determine the minimum number of columns that can be removed to ensure that each row is ordered from top to bottom lexicographically. That is, the letter at each column is lexicographically later as you go down each row. It does not matter whether each row itself is ordered lexicographically.

For example, given the following table:

cba
daf
ghi
This is not ordered because of the a in the center. We can remove the second column to make it ordered:

ca
df
gi
So your function should return 1, since we only needed to remove 1 column.

As another example, given the following table:

abcdef
Your function should return 0, since the rows are already ordered (there's only one row).

As another example, given the following table:

zyx
wvu
tsr
Your function should return 3, since we would need to remove all the columns to order it.
     */

    public static void main(String args[]) {
        char input1[][] = {
                {'z', 'y', 'x'},
                {'w', 'v', 'u'},
                {'t', 's', 'r'},
        };
        char input2[][] = {
                {'a', 'b', 'c', 'd', 'e', 'f'}
        };
        char input3[][] = {
                {'c', 'b', 'a'},
                {'d', 'a', 'f'},
                {'g', 'h', 'i'},
        };
        System.out.println(check(input1));
        System.out.println(check(input2));
        System.out.println(check(input3));
    }

    private static int check(char arr[][]) {
        int rows = arr.length;
        int colomns = arr[0].length;
        int badColomns = 0;
        for (int i = 0; i < colomns; i++) {
            for (int m = 1; m < rows; m++) {
                if (arr[m - 1][i] >= arr[m][i]) {
                    badColomns++;
                    break;
                }
            }
        }
        return badColomns;
    }
}
