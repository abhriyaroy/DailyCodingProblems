package dcm.dcp_1_to_10;

import javafx.util.Pair;

public class day5 {

    /*This problem was asked by Jane Street.

Cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(Cons(3, 4)) returns 3, and cdr(Cons(3, 4)) returns 4.

Given this implementation of Cons:

def Cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
Implement car and cdr.*/

    public static void main(String args[]) {
        Cons cons = new Cons(3, 5);
        System.out.println(cons.car());
        System.out.println(cons.cdr());
    }
}

class Cons {

    Pair<Integer, Integer> pair;

    Cons(int a, int b) {
        pair = new Pair<>(a, b);
    }

    int car() {
        return pair.getKey();
    }

    int cdr() {
        return pair.getValue();
    }
}
