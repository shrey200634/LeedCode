import java.util.HashMap;
import java.util.Map;

class LRUCache {
    public class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map; 
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        
        head.next = tail;
        tail.prev = head; 
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        removeNode(node);
        addToHead(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else {
            if (map.size() == capacity) {
                Node lruNode = tail.prev;
                removeNode(lruNode);
                map.remove(lruNode.key); 
            }
            
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
        }
    }


    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addToHead(Node node) {
        Node firstRealNode = head.next;
        
        head.next = node;
        node.prev = head;
        
        node.next = firstRealNode;
        firstRealNode.prev = node;
    }
}