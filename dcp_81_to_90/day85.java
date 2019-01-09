package dcm.dcp_81_to_90;

public class day85 {

    /*
    Given three 32-bit integers x, y, and b, return x if b is 1 and y if b is 0, using only mathematical or bit operations. You can assume b can only be 1 or 0.
     */

    public static void main(String args[]) {
        int x = 5;
        int y = 6;
        System.out.println(check(x, y, 0));
    }

    private static int check(int x, int y, int b) {
        return (x * b) + (y * (1 - b));
    }
}
