package dcm.dcp_1_to_10;

import java.util.concurrent.Callable;

public class day10 {

    /*This problem was asked by Apple.

Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.*/

    public static void main(String args[]){
        jobScheduler(new Callable() {
            @Override
            public Object call() throws Exception {
                return runScheduler();
            }
        }, 2000);
    }

    static void jobScheduler(Callable func, long n){
        while (true){
            try {
                Thread.sleep(n);
                func.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static Object runScheduler(){
        System.out.println("abcbcbc");
        return null;
    }
}
