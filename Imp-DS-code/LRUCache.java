import java.util.HashMap;

class LRUCache {
    doublyLinkedList head;
    doublyLinkedList teal;
    HashMap<Integer, doublyLinkedList> map;
    int capacity;

    public LRUCache(int capacity) {
        head=new doublyLinkedList();
        teal=new doublyLinkedList();
        head.next = teal;
        teal.prev = head;
        this.capacity = capacity;
        map = new HashMap<>();
        map.clear();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            doublyLinkedList node=map.get(key);
            deleteNode(node);
            insertAfterHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            doublyLinkedList node=map.get(key);
            node.value=value;
            deleteNode(node);
            insertAfterHead(node);
            return;
        }
        if (map.size()==capacity) {
            map.remove(teal.prev.key);
            deleteNode(teal.prev);
        }
        doublyLinkedList newNode=new doublyLinkedList(key, value);
        insertAfterHead(newNode);
        map.put(key, newNode);
    }

    public void deleteNode(doublyLinkedList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAfterHead(doublyLinkedList node) {
        doublyLinkedList nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }

}

class doublyLinkedList {
    int key;
    int value;
    doublyLinkedList next;
    doublyLinkedList prev;

    doublyLinkedList(int _key, int _value) {
        this.key = _key;
        this.value = _value;
        next = null;
        prev = null;
    }
    doublyLinkedList(){
        key=-1;
        value=-1;
        next=null;
        prev=null;
    }
}
public class Solution {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);

        // Measure time for put operation
        int putIterations = 1000000; // Number of iterations for put
        long startPut = System.nanoTime();
        for (int i = 0; i < putIterations; i++) {
            lruCache.put(i, i * 10);
        }
        long endPut = System.nanoTime();
        long elapsedPut = endPut - startPut; // Total time for put operations
        System.out.println("Total time taken for put operations: " + elapsedPut + " nanoseconds");

        // Measure time for get operation
        int getIterations = 1000000; // Number of iterations for get
        long startGet = System.nanoTime();
        for (int i = 0; i < getIterations; i++) {
            lruCache.get(i % 10); // Access keys in a loop
        }
        long endGet = System.nanoTime();
        long elapsedGet = endGet - startGet; // Total time for get operations
        System.out.println("Total time taken for get operations: " + elapsedGet + " nanoseconds");
    }
}