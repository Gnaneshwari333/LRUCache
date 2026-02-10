import java.util.*;

public class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addToFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToFront(newNode);
        if (map.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }

    // Helper to see the current state of the cache
    public void display() {
        System.out.print("Current Cache (MRU -> LRU): ");
        Node curr = head.next;
        while (curr != tail) {
            System.out.print("[" + curr.key + ":" + curr.value + "] ");
            curr = curr.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Cache Capacity: ");
        int cap = scanner.nextInt();
        LRUCache cache = new LRUCache(cap);

        while (true) {
            System.out.println("--- LRU Cache Menu ---");
            System.out.println("1. Put (Add/Update)");
            System.out.println("2. Get (Retrieve)");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter Key: ");
                int key = scanner.nextInt();
                System.out.print("Enter Value: ");
                int val = scanner.nextInt();
                cache.put(key, val);
                cache.display();
            } else if (choice == 2) {
                System.out.print("Enter Key to Get: ");
                int key = scanner.nextInt();
                int res = cache.get(key);
                System.out.println("Result: " + (res == -1 ? "Key Not Found" : res));
                cache.display();
            } else if (choice == 3) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}

class Node {
    int key, value;
    Node prev, next;
    Node(int k, int v) { this.key = k; this.value = v; }
}