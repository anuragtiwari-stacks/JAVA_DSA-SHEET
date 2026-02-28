package _04LinkedList;

public class _14SubtractTwoLinkedLists
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

    public static Node subtractTwoLists(Node l1, Node l2)
    {
        Node dummy = new Node(0);
        Node tail = dummy;

        int borrow = 0;

        while (l1 != null)
        {
            int diff = l1.data - borrow - (l2 != null ? l2.data : 0);

            if (diff < 0)
            {
                diff += 10;
                borrow = 1;
            }
            else
            {
                borrow = 0;
            }

            tail.next = new Node(diff);
            tail = tail.next;

            l1 = l1.next;
            if (l2 != null)
            {
                l2 = l2.next;
            }
        }

        Node result = removeTrailingZeros(dummy.next);

        return result == null ? new Node(0) : result;
    }

    private static Node removeTrailingZeros(Node head)
    {
        if (head == null)
        {
            return null;
        }

        head = reverseList(head);

        while (head != null && head.data == 0)
        {
            head = head.next;
        }

        head = reverseList(head);

        return head;
    }

    private static Node reverseList(Node head)
    {
        Node prev = null;
        Node curr = head;

        while (curr != null)
        {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void printList(Node head)
    {
        Node curr = head;
        while (curr != null)
        {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Node l1 = new Node(7);
        l1.next = new Node(8);
        l1.next.next = new Node(6);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        Node result = subtractTwoLists(l1, l2);

        System.out.print("Difference List: ");
        printList(result);
    }
}
