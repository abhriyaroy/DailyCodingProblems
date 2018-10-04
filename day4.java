package dcm;

import java.util.HashMap;
import java.util.TreeMap;

public class day4 {

    public static void main(String args[]) {
        int a[] = {1,2,0};
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            hashMap.put(a[i], i);
        }
       int i=1;
        while (i< Integer.MAX_VALUE){
            if (!hashMap.containsKey(i)){
                System.out.println(i);
                break;
            }
            i++;
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    }
}
