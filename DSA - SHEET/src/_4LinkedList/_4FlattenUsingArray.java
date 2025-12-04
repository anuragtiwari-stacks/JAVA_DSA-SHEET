package _4LinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class _4FlattenUsingArray
{
    static class Node
    {
        int data;
        Node next;
        Node bottom;

        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }

    public static Node flatten(Node head)
    {
        if (head == null)
            return null;

        ArrayList<Integer> allData = new ArrayList<>();

        Node temp = head;
        while (temp != null)
        {
            Node b = temp;
            while (b != null)
            {
                allData.add(b.data);
                b = b.bottom;
            }
            temp = temp.next;
        }

        Collections.sort(allData);

        Node dummy = new Node(0);
        Node current = dummy;
        for (int val : allData)
        {
            current.bottom = new Node(val);
            current = current.bottom;
        }

        return dummy.bottom;
    }

    public static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " -> ");
            head = head.bottom;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args)
    {
        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        System.out.println("Flattened list using Array and Sort:");
        Node flat = flatten(head);
        printList(flat);
    }
}
