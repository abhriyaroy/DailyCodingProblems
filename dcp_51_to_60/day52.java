package dcm.dcp_51_to_60;

import java.util.HashMap;

public class day52 {

    /*
    Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:

set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least recently used item.
get(key): gets the value at key. If no such key exists, return null.
Each operation should run in O(1) time.
     */

    public static void main(String args[]) {
        day52 obj = new day52(3);
        obj.put(5, 5);
        obj.put(6, 6);
        obj.put(3, 3);
        obj.get(5);
        obj.put(4, 4);
        if (obj.get(6) == Integer.MIN_VALUE) {
            System.out.println("Doesn't exist in cache");
        } else {
            System.out.println(obj.get(6));
        }
    }

    // Define Node with pointers to the previous and next items and a key, value pair
    class Node {
        Node previous;
        Node next;
        int key;
        int value;

        Node(Node previous, Node next, int key, int value) {
            this.previous = previous;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> cache;
    private Node leastRecentlyUsed;
    private Node mostRecentlyUsed;
    private int maxSize;
    private int currentSize;

    day52(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        leastRecentlyUsed = new Node(null, null, Integer.MIN_VALUE, Integer.MIN_VALUE);
        mostRecentlyUsed = leastRecentlyUsed;
        cache = new HashMap<>();
    }

    public int get(int key) {
        Node tempNode = cache.get(key);
        if (tempNode == null) {
            return Integer.MIN_VALUE;
        }
        // If MRU leave the list as it is
        else if (tempNode.key == mostRecentlyUsed.key) {
            return mostRecentlyUsed.value;
        }

        // Get the next and previous nodes
        Node nextNode = tempNode.next;
        Node previousNode = tempNode.previous;

        // If at the left-most, we update LRU
        if (tempNode.key == leastRecentlyUsed.key) {
            nextNode.previous = null;
            leastRecentlyUsed = nextNode;
        }

        // If we are in the middle, we need to update the items before and after our item
        else if (tempNode.key != mostRecentlyUsed.key) {
            previousNode.next = nextNode;
            nextNode.previous = previousNode;
        }

        // Finally move our item to the MRU
        tempNode.previous = mostRecentlyUsed;
        mostRecentlyUsed.next = tempNode;
        mostRecentlyUsed = tempNode;
        mostRecentlyUsed.next = null;

        return tempNode.value;

    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            return;
        }

        // Put the new node at the right-most end of the linked-list
        Node myNode = new Node(mostRecentlyUsed, null, key, value);
        mostRecentlyUsed.next = myNode;
        cache.put(key, myNode);
        mostRecentlyUsed = myNode;

        // Delete the left-most entry and update the LRU pointer
        if (currentSize == maxSize) {
            cache.remove(leastRecentlyUsed.key);
            leastRecentlyUsed = leastRecentlyUsed.next;
            leastRecentlyUsed.previous = null;
        }

        // Update cache size, for the first added entry update the LRU pointer
        else if (currentSize < maxSize) {
            if (currentSize == 0) {
                leastRecentlyUsed = myNode;
            }
            currentSize++;
        }
    }
}
