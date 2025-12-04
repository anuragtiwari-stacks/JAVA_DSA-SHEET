package _4LinkedList;

public class _1Merge_k_SortedList_Pairwise
{
    static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    // Merge two sorted linked lists using dummy node
    public static Node mergeLists(Node l1, Node l2)
    {
        Node dummy = new Node(0);  // Dummy node
        Node tail = dummy;

        while (l1 != null && l2 != null)
        {
            if (l1.data < l2.data)
            {
                tail.next = l1;
                l1 = l1.next;
            }
            else
            {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes
        if (l1 != null)
        {
            tail.next = l1;
        }
        else
        {
            tail.next = l2;
        }

        return dummy.next;
    }

    // Add a node to the end of a linked list
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

    // Print linked list
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
        // Declare lists without explicit null initialization
        Node l1;
        l1 = add(null, 1);
        l1 = add(l1, 4);
        l1 = add(l1, 5);

        Node l2;
        l2 = add(null, 1);
        l2 = add(l2, 3);
        l2 = add(l2, 4);

        Node l3;
        l3 = add(null, 2);
        l3 = add(l3, 6);

        // Print original lists
        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        System.out.print("List 3: ");
        printList(l3);

        // Step 1: merge l1 and l2 → l
        Node l = mergeLists(l1, l2);

        System.out.print("Merged List (l1 + l2): ");
        printList(l);

        // Step 2: merge l and l3
        Node finalMerged = mergeLists(l, l3);

        System.out.print("Final Merged List (l1 + l2 + l3): ");
        printList(finalMerged);
    }
}
