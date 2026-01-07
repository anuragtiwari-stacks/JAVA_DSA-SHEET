package _1ARRAY_1D._4ContainsDuplicate;

import java.util.HashSet;

public class HashSetExample
{
    public static void main(String[] args)
    {
        // Create a HashSet of integers
        HashSet<Integer> set = new HashSet<>();

        // Add elements to the set
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10);  // Duplicate element, will not be added again

        // Print the set (order is not guaranteed)
        System.out.println("HashSet elements: " + set);

        // Check if an element exists in the set
        if (set.contains(20))
        {
            System.out.println("20 is present in the set");
        }

        // Remove an element
        set.remove(30);
        System.out.println("After removing 30: " + set);

        // Size of the set
        System.out.println("Size of the set: " + set.size());
    }
}

/*
HashSet Summary
HashSet is a Java collection that stores unique elements only (no duplicates).
It provides fast operations for adding, searching, and removing elements (average time O(1)).
The elements are not stored in any specific order.
Commonly used when you need to check for duplicates or quickly test membership of elements.

Example use cases:
Detecting duplicates in an array.
Storing unique items from a list.
Performing fast membership queries.
*/