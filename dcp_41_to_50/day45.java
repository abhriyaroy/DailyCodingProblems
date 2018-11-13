package dcm.dcp_41_to_50;


import java.util.Random;

public class day45 {

    /*This problem was asked by Two Sigma.

Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, implement a function rand7() that returns an integer from 1 to 7 (inclusive).*/

    public static void main(String args[]) {
        System.out.println(rand7());
    }

    private static int rand5() {
        Random random = new Random();
        return random.nextInt(6);
    }

    private static int rand7() {
        int randomRange = 5 * rand5() + rand5() - 5;
        if (randomRange < 22) {
            return randomRange % 7 + 1;
        }
        return rand7();
    }

}
