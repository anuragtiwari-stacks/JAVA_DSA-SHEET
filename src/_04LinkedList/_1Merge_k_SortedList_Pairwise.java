package _04LinkedList;

public class _1Merge_k_SortedList_Pairwise
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

    public static Node mergeLists(Node l1, Node l2)
    {
        Node dummy = new Node(0);
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
        Node l1 = null;
        l1 = add(l1, 1);
        l1 = add(l1, 4);
        l1 = add(l1, 5);

        Node l2 = null;
        l2 = add(l2, 1);
        l2 = add(l2, 3);
        l2 = add(l2, 4);

        Node l3 = null;
        l3 = add(l3, 2);
        l3 = add(l3, 6);

        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        System.out.print("List 3: ");
        printList(l3);

        Node merged12 = mergeLists(l1, l2);
        System.out.print("Merged List (l1 + l2): ");
        printList(merged12);

        Node finalMerged = mergeLists(merged12, l3);
        System.out.print("Final Merged List (l1 + l2 + l3): ");
        printList(finalMerged);
    }
}
