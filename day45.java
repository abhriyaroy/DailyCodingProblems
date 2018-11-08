package dcm;


import java.util.Random;

public class day45 {

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
