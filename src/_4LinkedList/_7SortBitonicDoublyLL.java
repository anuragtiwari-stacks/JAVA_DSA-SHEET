package _4LinkedList;

public class _7SortBitonicDoublyLL
{
    static class Node
    {
        int data;
        Node prev;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
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
        newNode.prev = temp;

        return head;
    }

    public static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " <-> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static Node reverse(Node head)
    {
        Node temp = null;
        Node current = head;

        while (current != null)
        {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null)
        {
            head = temp.prev;
        }

        return head;
    }

    public static Node merge(Node first, Node second)
    {
        if (first == null)
        {
            return second;
        }

        if (second == null)
        {
            return first;
        }

        if (first.data < second.data)
        {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        }
        else
        {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    public static Node sortBitonic(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node curr = head;

        while (curr.next != null && curr.data < curr.next.data)
        {
            curr = curr.next;
        }

        if (curr.next == null)
        {
            return head;
        }

        Node second = curr.next;
        curr.next = null;
        second.prev = null;

        second = reverse(second);

        return merge(head, second);
    }

    public static void main(String[] args)
    {
        Node head = null;

        head = add(head, 10);
        head = add(head, 20);
        head = add(head, 30);
        head = add(head, 25);
        head = add(head, 15);
        head = add(head, 5);

        System.out.println("Original Bitonic Doubly Linked List:");
        printList(head);

        head = sortBitonic(head);

        System.out.println("Sorted Doubly Linked List:");
        printList(head);
    }
}
