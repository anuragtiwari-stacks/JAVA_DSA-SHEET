/*
Given a linked list, rearrange it such that the converted list should be of the form
a < b > c < d > e < f … where a, b, c… are consecutive data nodes of the linked list.

Examples:

Input:  1->2->3->4
Output: 1->3->2->4
Explanation : 1 and 3 should come first before 2 and 4 in zig-zag fashion, So resultant linked-list will be 1->3->2->4.

Input:  11->15->20->5->10
Output: 11->20->5->15->10
 */
package _4LinkedList;

public class _12ZigZagLinkedList
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

    public static void zigZag(Node head)
    {
        Node curr = head;
        int i = 0;

        while (curr != null && curr.next != null)
        {
            if (i % 2 == 0)
            {
                if (curr.data > curr.next.data)
                {
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }
            else
            {
                if (curr.data < curr.next.data)
                {
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }

            curr = curr.next;
            i++;
        }
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
        Node head = new Node(11);
        head.next = new Node(15);
        head.next.next = new Node(20);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(10);

        System.out.print("Original List: ");
        printList(head);

        zigZag(head);

        System.out.print("Zig-Zag List: ");
        printList(head);
    }
}
