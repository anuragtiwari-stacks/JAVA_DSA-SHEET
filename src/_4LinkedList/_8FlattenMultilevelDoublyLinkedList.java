package _4LinkedList;

public class _8FlattenMultilevelDoublyLinkedList
{
    static class Node
    {
        int data;
        Node prev;
        Node next;
        Node child;

        Node(int data)
        {
            this.data = data;
            this.prev = null;
            this.next = null;
            this.child = null;
        }
    }

    public Node flatten(Node head)
    {
        if (head == null)
        {
            return null;
        }

        Node curr = head;

        while (curr != null)
        {
            if (curr.child == null)
            {
                curr = curr.next;
            }
            else
            {
                Node next = curr.next;

                Node childHead = flatten(curr.child);

                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;

                Node tail = childHead;
                while (tail.next != null)
                {
                    tail = tail.next;
                }

                if (next != null)
                {
                    tail.next = next;
                    next.prev = tail;
                }

                curr = next;
            }
        }

        return head;
    }

    public void printList(Node head)
    {
        Node temp = head;

        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        _8FlattenMultilevelDoublyLinkedList solution =
                new _8FlattenMultilevelDoublyLinkedList();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        n5.next = n6; n6.prev = n5;

        n7.next = n8; n8.prev = n7;
        n8.next = n9; n9.prev = n8;
        n9.next = n10; n10.prev = n9;

        n11.next = n12; n12.prev = n11;

        n3.child = n7;
        n8.child = n11;

        Node flattenedHead = solution.flatten(n1);

        solution.printList(flattenedHead);
    }
}
