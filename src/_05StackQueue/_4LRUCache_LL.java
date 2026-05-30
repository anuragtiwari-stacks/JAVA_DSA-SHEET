package _05StackQueue;

import java.util.HashMap;

public class _4LRUCache_LL
{
    // DOUBLY LINKED LIST NODE
    class Node
    {
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    // key -> node
    private HashMap<Integer, Node> map = new HashMap<>();

    // dummy nodes
    private Node head = new Node(0, 0);
    private Node tail = new Node(0, 0);

    public _4LRUCache_LL(int capacity)
    {
        this.capacity = capacity;

        // connect head and tail
        head.next = tail;
        tail.prev = head;
    }

    // ADD NODE AFTER HEAD
    // most recently used position
    private void addNode(Node node)
    {
        Node nextNode = head.next;

        head.next = node;
        node.prev = head;

        node.next = nextNode;
        nextNode.prev = node;
    }

    // REMOVE NODE
    private void removeNode(Node node)
    {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // MOVE NODE TO FRONT
    private void moveToFront(Node node)
    {
        removeNode(node);
        addNode(node);
    }

    // GET
    public int get(int key)
    {
        // key not found
        if (!map.containsKey(key))
        {
            return -1;
        }

        Node node = map.get(key);

        // recently used
        moveToFront(node);

        return node.value;
    }

    // PUT
    public void put(int key, int value)
    {
        // key already exists
        if (map.containsKey(key))
        {
            Node oldNode = map.get(key);

            oldNode.value = value;

            moveToFront(oldNode);
        }
        else
        {
            Node newNode = new Node(key, value);

            // add in hashmap
            map.put(key, newNode);

            // add in linked list
            addNode(newNode);

            // capacity exceeded
            if (map.size() > capacity)
            {
                // least recently used node
                Node lru = tail.prev;

                removeNode(lru);

                map.remove(lru.key);
            }
        }
    }

    public static void main(String[] args)
    {
        _4LRUCache_LL cache = new _4LRUCache_LL(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1));

        cache.put(3, 30);

        System.out.println(cache.get(2));

        cache.put(4, 40);

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

/*
------------------------------------------------
DRY RUN
------------------------------------------------

Capacity = 2

HEAD <-> TAIL

------------------------------------------------
put(1,10)

HEAD <-> 1 <-> TAIL

map =
{
 1 -> node
}

------------------------------------------------
put(2,20)

HEAD <-> 2 <-> 1 <-> TAIL

2 = most recent
1 = least recent

------------------------------------------------
get(1)

move 1 to front

HEAD <-> 1 <-> 2 <-> TAIL

return 10

------------------------------------------------
put(3,30)

capacity exceeded

remove least recent = 2

HEAD <-> 3 <-> 1 <-> TAIL

------------------------------------------------
get(2)

not found

return -1

------------------------------------------------
put(4,40)

remove least recent = 1

HEAD <-> 4 <-> 3 <-> TAIL

------------------------------------------------
Outputs

get(1) = -1
get(3) = 30
get(4) = 40

------------------------------------------------
TIME COMPLEXITY
------------------------------------------------

get() -> O(1)
put() -> O(1)

------------------------------------------------
*/