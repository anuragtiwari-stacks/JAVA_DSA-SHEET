package _4LinkedList;

public class _4FlattenUsingRecursive
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

    public static Node merge(Node a, Node b)
    {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null)
        {
            if (a.data < b.data)
            {
                tail.bottom = a;
                a = a.bottom;
            }
            else
            {
                tail.bottom = b;
                b = b.bottom;
            }
            tail = tail.bottom;
        }

        if (a != null)
        {
            tail.bottom = a;
        }
        else
        {
            tail.bottom = b;
        }

        return dummy.bottom;
    }

    public static Node flatten(Node root)
    {
        if (root == null || root.next == null)
        {
            return root;
        }

        root.next = flatten(root.next);

        root = merge(root, root.next);

        root.next = null;

        return root;
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

        System.out.println("Flattened list using Recursive Merge:");
        Node flat = flatten(head);
        printList(flat);
    }
}


/*
Dry Run: FlattenUsingRecursiveMerge on example linked list

Input:
Main list (next pointers):
5 -> 10 -> 19 -> 28

Each node’s bottom list:
5: 7 -> 8 -> 30
10: 20
19: 22 -> 50
28: 35 -> 40 -> 45

Step 1: flatten(28)
- No next after 28, returns list as is:
  28 -> 35 -> 40 -> 45

Step 2: flatten(19)
- flatten(19.next) = flatten(28) = 28 -> 35 -> 40 -> 45
- Merge lists:
  19 -> 22 -> 50
  28 -> 35 -> 40 -> 45

Merge process:
- Compare 19 and 28 → 19 < 28 → add 19
- Compare 22 and 28 → 22 < 28 → add 22
- Compare 50 and 28 → 28 < 50 → add 28
- Compare 50 and 35 → 35 < 50 → add 35
- Compare 50 and 40 → 40 < 50 → add 40
- Compare 50 and 45 → 45 < 50 → add 45
- Add remaining 50

Result:
19 -> 22 -> 28 -> 35 -> 40 -> 45 -> 50

Step 3: flatten(10)
- flatten(10.next) = flatten(19) = above merged list
- Merge lists:
  10 -> 20
  19 -> 22 -> 28 -> 35 -> 40 -> 45 -> 50

Merge process:
- 10 < 19 → add 10
- 20 < 19? No → add 19
- 20 < 22 → add 20
- Add rest 22 -> 28 -> 35 -> 40 -> 45 -> 50

Result:
10 -> 19 -> 20 -> 22 -> 28 -> 35 -> 40 -> 45 -> 50

Step 4: flatten(5)
- flatten(5.next) = flatten(10) = above merged list
- Merge lists:
  5 -> 7 -> 8 -> 30
  10 -> 19 -> 20 -> 22 -> 28 -> 35 -> 40 -> 45 -> 50

Merge process:
- 5 < 10 → add 5
- 7 < 10 → add 7
- 8 < 10 → add 8
- 30 < 10? No → add 10
- 30 < 19? No → add 19
- 30 < 20? No → add 20
- 30 < 22? No → add 22
- 30 < 28? No → add 28
- 30 < 35 → add 30
- Add remaining 35 -> 40 -> 45 -> 50

Final flattened list (bottom pointers):
5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 30 -> 35 -> 40 -> 45 -> 50 -> NULL
*/
