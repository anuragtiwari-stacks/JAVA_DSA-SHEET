package _04LinkedList;

public class _10Sort012LinkedList
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

    static Node sort012(Node head)
    {
        int[] count = new int[3];

        Node curr = head;
        while (curr != null)
        {
            count[curr.data]++;
            curr = curr.next;
        }

        curr = head;
        int i = 0;

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
