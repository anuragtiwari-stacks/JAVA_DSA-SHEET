package _4LinkedList;

public class _15MultiplyTwoLinkedLists
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

    public static Node multiplyLists(Node l1, Node l2)
    {
        if (l1 == null || l2 == null)
        {
            return new Node(0);
        }

        int len1 = getLength(l1);
        int len2 = getLength(l2);

        int[] result = new int[len1 + len2];

        Node p1 = l1;
        int i = 0;

        while (p1 != null)
        {
            Node p2 = l2;
            int j = 0;

            while (p2 != null)
            {
                result[i + j] += p1.data * p2.data;
                p2 = p2.next;
                j++;
            }

            p1 = p1.next;
            i++;
        }

        for (int k = 0; k < result.length - 1; k++)
        {
            result[k + 1] += result[k] / 10;
            result[k] = result[k] % 10;
        }

        int len = result.length;
        while (len > 1 && result[len - 1] == 0)
        {
            len--;
        }

        Node head = new Node(result[0]);
        Node curr = head;

        for (int idx = 1; idx < len; idx++)
        {
            curr.next = new Node(result[idx]);
            curr = curr.next;
        }

        return head;
    }

    private static int getLength(Node head)
    {
        int length = 0;
        Node temp = head;

        while (temp != null)
        {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public static void printList(Node head)
    {
        Node curr = head;

        while (curr != null)
        {
            System.out.print(curr.data);
            if (curr.next != null)
            {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        Node l1 = new Node(3);
        l1.next = new Node(4);
        l1.next.next = new Node(2);

        Node l2 = new Node(4);
        l2.next = new Node(6);
        l2.next.next = new Node(5);

        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        Node product = multiplyLists(l1, l2);

        System.out.print("Product List: ");
        printList(product);
    }
}
