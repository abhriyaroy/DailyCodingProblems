package dcm;

import java.util.ArrayList;

public class day47 {

    /*This problem was asked by Facebook.

Given a array of numbers representing the stock prices of a company in chronological order, write a function that calculates the maximum profit you could have made from buying and selling that stock once. You must buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.*/

    public static void main(String args[]) {
        int input[] = {9, 11, 8, 5, 7, 10};
        calculateStock(input);

    }

    private static void calculateStock(int arr[]) {
        int size = arr.length;
        int buy, sell, profit = 0, finalSell = 0, finalBuy = 0;
        int i = 0;
        while (i < size - 1) {
            while (i < size - 1 && arr[i + 1] <= arr[i]) {
                i++;
            }

            if (i == size - 1) {
                System.out.println("cant purchase with profit");
                break;
            }

            buy = arr[i];
            ArrayList<Integer> purchase = new ArrayList<>();
            purchase.add(i++);

            while (i < size && arr[i] >= arr[i - 1]) {
                i++;
            }

            sell = arr[i - 1];
            purchase.add(i - 1);

            int tempProfit = sell - buy;

            if (tempProfit > profit) {
                profit = tempProfit;
                finalBuy = buy;
                finalSell = sell;
            }

        }
        if (profit != 0) {
            System.out.println("Profit is " + profit + " by buying at " + finalBuy + " and selling at " + finalSell);
        }
    }
}
