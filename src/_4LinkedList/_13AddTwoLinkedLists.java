package _4LinkedList;

public class _13AddTwoLinkedLists
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

    public static Node addTwoLists(Node l1, Node l2)
    {
        Node dummy = new Node(0);
        Node tail = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0)
        {
            int sum = carry;

            if (l1 != null)
            {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null)
            {
                sum += l2.data;
                l2 = l2.next;
            }

            carry = sum / 10;
            int digit = sum % 10;

            tail.next = new Node(digit);
            tail = tail.next;
        }

        return dummy.next;
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
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        Node result = addTwoLists(l1, l2);

        System.out.print("Sum List: ");
        printList(result);
    }
}
