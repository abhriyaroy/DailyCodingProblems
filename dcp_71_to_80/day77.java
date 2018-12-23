package dcm.dcp_71_to_80;

import javafx.util.Pair;

import java.util.*;

public class day77 {

    /*
    This problem was asked by Snapchat.

Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.

The input list is not necessarily ordered in any way.

For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].
     */

    public static void main(String args[]) {
        List<Pair<Integer, Integer>> input = new ArrayList<>();
        input.add(new Pair<>(1, 3));
        input.add(new Pair<>(20, 25));
        input.add(new Pair<>(5, 8));
        input.add(new Pair<>(4, 10));
        for (Pair<Integer, Integer> output : getRangeList(input)) {
            System.out.println(output.getKey() + " " + output.getValue());
        }
    }

    private static List<Pair<Integer, Integer>> getRangeList(List<Pair<Integer, Integer>> inputList) {
        inputList = sort(inputList);
        List<Pair<Integer, Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            if (i != inputList.size() - 1 && inputList.get(i).getKey() < inputList.get(i + 1).getKey() && inputList.get(i).getValue() > inputList.get(i + 1).getValue()) {
                resultList.add(new Pair<>(inputList.get(i).getKey(), inputList.get(i).getValue()));
                i++;
                while (i < inputList.size()) {
                    if (i != inputList.size() - 1 && inputList.get(i).getKey() < inputList.get(i + 1).getKey() && inputList.get(i).getValue() > inputList.get(i + 1).getValue()) {
                        i++;
                    } else break;
                }
            } else resultList.add(new Pair<>(inputList.get(i).getKey(), inputList.get(i).getValue()));
        }
        return resultList;
    }


    private static List<Pair<Integer, Integer>> sort(List<Pair<Integer, Integer>> inputList) {
        Collections.sort(inputList, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (o1.getKey() < o2.getKey()) {
                    return -1;
                } else if (o1.getKey() > o2.getKey()) {
                    return 1;
                } else return 0;
            }
        });
        return inputList;
    }
}
