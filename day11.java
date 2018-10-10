package dcm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class day11 {

    /*This problem was asked by Twitter.

Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.*/

    private static TrieNode root;

    public static void main(String args[]) {
        String arr[] = {"dog", "deer", "deal"};
        root = new TrieNode();
        preProcess(arr);
        System.out.println(search("de").toString());
    }

    private static void preProcess(String arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

    }

    private static void insert(String str) {
        TrieNode reference = root;
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length()-1){
                reference.isTheEnd = true;
            }
            if (!reference.dict.containsKey(str.charAt(i))) {
                reference.dict.put(str.charAt(i), new TrieNode());
            }
            reference = reference.dict.get(str.charAt(i));
        }
    }

    private static ArrayList<String> search(String str) {
        TrieNode reference = root;
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            reference = reference.dict.get(str.charAt(i));
        }
        buildResults(reference, str, result);


        return result;
    }

    private static void buildResults(TrieNode ref, String prefix, ArrayList<String> result) {
        if (ref.isTheEnd) {
            for (Character suffix : ref.dict.keySet()) {
                result.add(prefix + suffix);
            }
            return;
        }

        for (Map.Entry<Character, TrieNode> entry : ref.dict.entrySet()) {
            buildResults(entry.getValue(), prefix + entry.getKey(), result);
        }
    }

}

class TrieNode {
    boolean isTheEnd;
    HashMap<Character, TrieNode> dict = new HashMap<>();
}
