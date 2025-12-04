package _4LinkedList;

public class _10Sort012LinkedList
{
    static class Node
    {
        int data;
        Node next;

        Node(int val)
        {
            data = val;
            next = null;
        }
    }

    // Function to sort the linked list containing 0, 1, 2 using count approach
    static Node sort012(Node head)
    {
        // Count array for 0,1,2
        int[] count = new int[3];  // count[0], count[1], count[2]

        Node curr = head;

        // Step 1: Count the frequency of 0,1,2
        while (curr != null)
        {
            count[curr.data]++;
            curr = curr.next;
        }

        curr = head;
        int i = 0;

        // Step 2: Overwrite the linked list data with sorted values
        while (curr != null)
        {
            if (count[i] == 0)
            {
                i++;
            }
            else
            {
                curr.data = i;
                count[i]--;
                curr = curr.next;
            }
        }

        return head;
    }

    // Helper function to print linked list
    static void printList(Node head)
    {
        Node curr = head;
        while (curr != null)
        {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args)
    {
        // Creating linked list: 1 -> 1 -> 2 -> 0 -> 2 -> 0 -> 1 -> NULL
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(0);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(1);

        System.out.print("Original List: ");
        printList(head);

        head = sort012(head);

        System.out.print("Sorted List: ");
        printList(head);
    }
}

/*
Dry Run:

Input List: 1 -> 1 -> 2 -> 0 -> 2 -> 0 -> 1 -> NULL

Count nodes:
count[0] = 2 (two 0's)
count[1] = 3 (three 1's)
count[2] = 2 (two 2's)

Overwrite nodes:
- Fill with 0s (2 times )
- Fill with 1s (3 times)
- Fill with 2s (2 times)

Output List:
0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2 -> NULL
*/
