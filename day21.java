package dcm;

import java.util.ArrayList;
import java.util.Arrays;

public class day21 {

    /*This problem was asked by Snapchat.

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.*/

    public static void main(String args[]) {
        Integer a[] = {30, 75};
        Integer b[] = {0, 50};
        Integer c[] = {60, 150};
        ArrayList<Integer[]> input = new ArrayList<>();
        input.add(a);
        input.add(b);
        input.add(c);

        int classes = 1;
        int classesCurrentlyInUse = 1;
        int size = input.size();
        int start[] = new int[size];
        int end[] = new int[size];
        for (int i = 0; i < size; i++) {
            start[i] = input.get(i)[0];
            end[i] = input.get(i)[1];
        }

        Arrays.parallelSort(start);
        Arrays.parallelSort(end);

        int i = 1, j = 0;
        while (i < size && j < size) {
            if (start[i] <= end[j]) {
                classesCurrentlyInUse++;
                i++;

                if (classesCurrentlyInUse > classes) {
                    classes = classesCurrentlyInUse;
                }
            } else {
                classesCurrentlyInUse--;
                j++;
            }
        }

        System.out.println("the maximum number of classes required are "+classes);
    }
}
