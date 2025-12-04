/*
Given a pointer to a node to be deleted, delete the node.
Note that we don’t have a pointer to the head node.

Examples:

Input: list = 10 -> 20 -> 4 -> 30, delNode = 20
Output: 10 -> 4 -> 30
Explanation: Node with value 20 is deleted.

Input: list = 1 -> 2, delNode = 1
Output: 2
Explanation: Node with value 1 is deleted.
*/
package _4LinkedList;

public class _9GFG
{
    static class Node
    {
        int data;
        Node next;

        Node(int val)
        {
            data = val;
            next = null;
        }
    }

    // Function to delete a node given only a reference to that node
    static void deleteNode(Node delNode) {
        // Cannot delete last node using this method
        if (delNode == null || delNode.next == null) {
            return;
        }

        // Step 1: Copy data from next node into current node
        Node temp = delNode.next;
        delNode.data = temp.data;

        // Step 2: Skip over next node
        delNode.next = temp.next;

        // Step 3: Clear next of removed node to help garbage collection (optional)
        temp.next = null;
    }

    // Helper function to print the linked list
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create linked list: 4 -> 5 -> 6 -> 7 -> 8
        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(6);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(8);

        System.out.print("Original List: ");
        printList(head);

        // Suppose we want to delete node with value 5, which is head.next
        Node delNode = head.next;

        // Delete node 5 using only reference to delNode
        deleteNode(delNode);

        System.out.print("List after deleting node with value 5: ");
        printList(head);
    }
}


/*
Dry Run Summary:
| Operation          | List Values           | Explanation                         |
| ------------------ | --------------------- | ----------------------------------- |
| Initial list       | 4 -> 5 -> 6 -> 7 -> 8 | Node to delete is `5`               |
| Step 1: copy data  | 4 -> 6 -> 6 -> 7 -> 8 | Copy `6` into node with `5`         |
| Step 2: skip next  | 4 -> 6 -> 7 -> 8      | Skip original node with `6`         |
| Step 3: clear next | 4 -> 6 -> 7 -> 8      | Remove references for GC (optional) |
*/