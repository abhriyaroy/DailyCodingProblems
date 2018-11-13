package dcm.dcp_21_to_30;

import java.util.ArrayList;
import java.util.HashMap;

public class day22 {

    /*This problem was asked by Microsoft.

Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].*/

    public static void main(String args[]) {
        HashMap<String, Integer> knownWords = new HashMap<>();
        knownWords.put("quick",0);
        knownWords.put("brown",1);
        knownWords.put("the",2);
        knownWords.put("fox",3);

        String input = "thequickbrownfox";
        ArrayList<String> result = new ArrayList<>();

        int start =0;
        for (int i=1; i<=input.length(); i++){
            String word = input.substring(start,i);
            if (knownWords.containsKey(word)){
                result.add(word);
                start = i;
            }
        }

        System.out.println(result.toString());
    }
}
