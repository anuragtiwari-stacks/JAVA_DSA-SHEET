package _4LinkedList;

public class _5FlattenLevelOrder
{
    static class Node
    {
        int data;
        Node next;
        Node child;

        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

    public static Node flattenList(Node head)
    {
        if (head == null)
        {
            return null;
        }

        Node curr = head;

        Node tail = head;
        while (tail.next != null)
        {
            tail = tail.next;
        }

        while (curr != null)
        {
            if (curr.child != null)
            {
                tail.next = curr.child;

                Node temp = curr.child;
                while (temp.next != null)
                {
                    temp = temp.next;
                }
                tail = temp;

                curr.child = null;
            }

            curr = curr.next;
        }

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
        Node head = new Node(1);
        Node node4 = new Node(4);
        Node node6 = new Node(6);

        head.next = node4;
        node4.next = node6;

        head.child = new Node(2);
        head.child.child = new Node(3);

        node4.child = new Node(5);
        node4.child.child = new Node(8);

        node6.child = new Node(7);

        System.out.println("Original (with children):");
        printList(head);

        Node flattened = flattenList(head);

        System.out.println("Flattened List:");
        printList(flattened);
    }
}



/*
Initial structure:
1 -> 4 -> 6
|    |    |
2    5    7
|    |
3    8

Step 1: Initial tail = 6

curr = 1 → has child(2)
    → tail.next = 2
    → tail moves to 3
    → child link removed

curr = 4 → has child(5)
    → tail.next = 5
    → tail moves to 8
    → child link removed

curr = 6 → has child(7)
    → tail.next = 7
    → tail = 7
    → child link removed

curr continues to 2 → no child
curr = 3 → no child
curr = 5 → no child
curr = 8 → no child
curr = 7 → no child

Final order:
1 → 4 → 6 → 2 → 5 → 7 → 3 → 8 → NULL
*/
