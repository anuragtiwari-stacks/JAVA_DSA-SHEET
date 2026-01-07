package _4LinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class _1Merge_k_SortedList_ArrayListApproach
{
    public static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public static Node mergeKLists(Node[] lists)
    {
        ArrayList<Integer> allData = new ArrayList<>();

        // Step 1: collect all values
        for (Node head : lists)
        {
            while (head != null)
            {
                allData.add(head.data);
                head = head.next;
            }
        }

        // Step 2: sort values
        Collections.sort(allData);

        // Step 3: build new list
        Node dummy = new Node(0);
        Node tail = dummy;

        for (int val : allData)
        {
            tail.next = new Node(val);
            tail = tail.next;
        }

        return dummy.next;
    }

    public static Node add(Node head, int data)
    {
        Node newNode = new Node(data);

        if (head == null)
        {
            return newNode;
        }

        Node temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    public static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args)
    {
        Node[] lists = new Node[3];

        lists[0] = add(lists[0], 1);
        lists[0] = add(lists[0], 4);
        lists[0] = add(lists[0], 5);

        lists[1] = add(lists[1], 1);
        lists[1] = add(lists[1], 3);
        lists[1] = add(lists[1], 4);

        lists[2] = add(lists[2], 2);
        lists[2] = add(lists[2], 6);

        System.out.println("Input Linked Lists:");
        for (int i = 0; i < lists.length; i++)
        {
            System.out.print("List " + (i + 1) + ": ");
            printList(lists[i]);
        }

        Node merged = mergeKLists(lists);

        System.out.print("Merged List: ");
        printList(merged);
    }
}



/*
🧪 Dry Run for Given Example:

Input Linked Lists:

List 1: 1 → 4 → 5
List 2: 1 → 3 → 4
List 3: 2 → 6

--------------------------------------------------
Step 1: Collect all node values from the lists
--------------------------------------------------
Traverse List 1: 1 → 4 → 5
  => allData = [1, 4, 5]

Traverse List 2: 1 → 3 → 4
  => allData = [1, 4, 5, 1, 3, 4]

Traverse List 3: 2 → 6
  => allData = [1, 4, 5, 1, 3, 4, 2, 6]

--------------------------------------------------
Step 2: Sort the collected values
--------------------------------------------------
Before sorting: [1, 4, 5, 1, 3, 4, 2, 6]
After sorting:  [1, 1, 2, 3, 4, 4, 5, 6]

--------------------------------------------------
Step 3: Build the new merged linked list
--------------------------------------------------
Start with dummy node (value = 0)

Attach 1 → dummy.next = 1
Attach 1 → 1 → 1
Attach 2 → 1 → 1 → 2
Attach 3 → 1 → 1 → 2 → 3
Attach 4 → 1 → 1 → 2 → 3 → 4
Attach 4 → 1 → 1 → 2 → 3 → 4 → 4
Attach 5 → 1 → 1 → 2 → 3 → 4 → 4 → 5
Attach 6 → 1 → 1 → 2 → 3 → 4 → 4 → 5 → 6

--------------------------------------------------
✅ Final Merged List:
--------------------------------------------------
1 → 1 → 2 → 3 → 4 → 4 → 5 → 6 → NULL
*/
