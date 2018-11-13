package dcm.dcp_11_to_20;

public class day16 {

    /*This problem was asked by Twitter.

You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

record(order_id): adds the order_id to the log
get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
You should be as efficient with time and space as possible.*/

    static int n = 5;
    private static int last = -1;
    private static int arr[] = new int[n];

    public static void main(String args[]) {
        record(111);
        record(178);
        record(135);
        record(150);
        record(115);

        get_last(3);
        get_last(5);
        get_last(1);
    }

    private static void record(int id) {
        if (last+1 < n) {
            last++;
            arr[last] = id;
        } else {
            System.out.println("overflow");
        }
    }

    private static void get_last(int pos) {
        try {
            System.out.println(arr[last - pos + 1]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
