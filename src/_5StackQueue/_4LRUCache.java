package _5StackQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _4LRUCache
{
    /*
    LOGIC (Queue-based LRU):
    -----------------------
    1. Queue usage order maintain karegi.
       - Front  -> Least Recently Used (LRU)
       - Rear   -> Most Recently Used (MRU)

    2. HashMap key -> value store karega.

    get(key):
      - Agar key nahi hai -> -1
      - Agar key hai:
        -> queue se key remove karo
        -> queue ke end me add karo (recent banane ke liye)
        -> value return karo

    put(key, value):
      - Agar key already hai:
        -> queue se remove
        -> queue ke end me add
        -> value update
      - Agar key new hai:
        -> agar capacity full:
           - queue ka front remove (LRU)
           - map se bhi remove
        -> new key ko queue ke end me add
        -> map me store
    */

    private int capacity;
    private Queue<Integer> queue;
    private HashMap<Integer, Integer> map;

    public _4LRUCache(int capacity)
    {
        this.capacity = capacity;
        queue = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key)
    {
        if (!map.containsKey(key))
        {
            return -1;
        }

        // recent banane ke liye
        queue.remove(key);     // O(n)
        queue.add(key);

        return map.get(key);
    }

    public void put(int key, int value)
    {
        if (map.containsKey(key))
        {
            queue.remove(key); // O(n)
        }
        else
        {
            if (queue.size() == capacity)
            {
                int lru = queue.poll(); // front se remove
                map.remove(lru);
            }
        }

        queue.add(key);
        map.put(key, value);
    }

    public static void main(String[] args)
    {
        _4LRUCache cache = new _4LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1

        cache.put(3, 3);
        System.out.println(cache.get(2)); // -1

        cache.put(4, 4);
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}

/*
DRY RUN:
-------------------------------

Capacity = 2

queue = []
map   = {}

--------------------------------
put(1,1)
queue = [1]
map   = {1=1}

--------------------------------
put(2,2)
queue = [1, 2]
map   = {1=1, 2=2}

--------------------------------
get(1)
queue.remove(1)
queue.add(1)

queue = [2, 1]
map   = {1=1, 2=2}
Output = 1

--------------------------------
put(3,3)
capacity full
remove LRU = 2

queue = [1]
map   = {1=1}

add 3

queue = [1, 3]
map   = {1=1, 3=3}

--------------------------------
get(2)
2 not in map
Output = -1

--------------------------------
put(4,4)
capacity full
remove LRU = 1

queue = [3]
map   = {3=3}

add 4

queue = [3, 4]
map   = {3=3, 4=4}

--------------------------------
get(1) -> -1
get(3) -> 3
get(4) -> 4

FINAL OUTPUT:
-------------
[null, null, null, 1, null, -1, null, -1, 3, 4]
*/
