package dcm.dcp_11_to_20;

import java.util.List;
import java.util.Random;

public class day15 {

    /*
    This problem was asked by Facebook.

Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.
     */

    public static void main(String args[]) {
        // Pass large stream to function somehow
    }

    private Integer handleBigStream(List<Integer> bigStream) {
        Integer randomElement = null;
        for (int i = 0; i < bigStream.size(); i++) {
            Random randomInt = new Random();
            if (randomInt.nextInt(i + 1) == 1) {
                randomElement = bigStream.size();
            }
        }
        return randomElement;
    }
}
