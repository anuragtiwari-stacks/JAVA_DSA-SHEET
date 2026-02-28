/*
Given a singly linked list with every node having an additional arbitrary pointer that currently points to NULL.
The task is to make the arbitrary pointer point to the next higher-value node.
*/
package _04LinkedList;

public class _11NextHigherNode
{
    static class Node
    {
        int data;
        Node next;
        Node arbitrary;

        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.arbitrary = null;
        }
    }

    public static void setNextHigher(Node head)
    {
        Node current = head;

        while (current != null)
        {
            Node temp = current.next;
            current.arbitrary = null;

            while (temp != null)
            {
                if (temp.data > current.data)
                {
                    current.arbitrary = temp;
                    break;
                }
                temp = temp.next;
            }

            current = current.next;
        }
    }

    public static void printListWithArbitrary(Node head)
    {
        Node curr = head;

        while (curr != null)
        {
            System.out.print(curr.data + " -> Next Higher: ");

            if (curr.arbitrary != null)
            {
                System.out.println(curr.arbitrary.data);
            }
            else
            {
                System.out.println("null");
            }

            curr = curr.next;
        }
    }

    public static void main(String[] args)
    {
        Node head = new Node(2);
        head.next = new Node(7);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next = new Node(4);

        setNextHigher(head);

        printListWithArbitrary(head);
    }
}


