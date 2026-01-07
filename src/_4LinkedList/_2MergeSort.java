package _4LinkedList;

public class _2MergeSort
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

    public static Node merge(Node l1, Node l2)
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

    public static Node getMiddle(Node head)
    {
        if (head == null)
        {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node mergeSort(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        return merge(left, right);
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
        Node head = null;

        head = add(head, 4);
        head = add(head, 2);
        head = add(head, 1);
        head = add(head, 3);
        head = add(head, 5);

        System.out.print("Original List: ");
        printList(head);

        head = mergeSort(head);

        System.out.print("Sorted List: ");
        printList(head);
    }
}
