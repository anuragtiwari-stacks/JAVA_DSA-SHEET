package _05StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class _1StackUsingQueues
{
    /*
        LOGIC:
        ------
        1. Stack follows LIFO (Last In First Out).
        2. Queue follows FIFO (First In First Out).
        3. Use two queues q1 and q2.
        4. Push:
           - Add element to q2
           - Move all elements of q1 to q2
           - Swap q1 and q2
        5. Pop:
           - Remove element from q1
        6. Top:
           - Peek element from q1
    */

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation
    public void push(int x)
    {
        q2.add(x);

        while (!q1.isEmpty())
        {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation
    public int pop()
    {
        if (q1.isEmpty())
        {
            System.out.println("Stack is empty");
            return -1;
        }

        return q1.remove();
    }

    // Top operation
    public int top()
    {
        if (q1.isEmpty())
        {
            System.out.println("Stack is empty");
            return -1;
        }

        return q1.peek();
    }

    // Check if stack is empty
    public boolean isEmpty()
    {
        return q1.isEmpty();
    }

    public static void main(String[] args)
    {
        _1StackUsingQueues stack = new _1StackUsingQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}

/*
Initial State:
--------------
q1 = []
q2 = []


=====================
push(10)
=====================

Step 1: q2.add(10)
q1 = []
q2 = [10]

Step 2: move all elements from q1 to q2
(q1 already empty, nothing moves)

q1 = []
q2 = [10]

Step 3: swap q1 and q2

q1 = [10]
q2 = []


=====================
push(20)
=====================

Step 1: q2.add(20)
q1 = [10]
q2 = [20]

Step 2: move all elements from q1 to q2

remove 10 from q1 → add to q2

q1 = []
q2 = [20, 10]

Step 3: swap q1 and q2

q1 = [20, 10]
q2 = []


=====================
push(30)
=====================

Step 1: q2.add(30)
q1 = [20, 10]
q2 = [30]

Step 2: move all elements from q1 to q2

remove 20 → add to q2
q1 = [10]
q2 = [30, 20]

remove 10 → add to q2
q1 = []
q2 = [30, 20, 10]

Step 3: swap q1 and q2

q1 = [30, 20, 10]
q2 = []


Final Stack Representation:
---------------------------
TOP → 30 20 10

top():
returns 30

pop():
removes 30
q1 = [20, 10]

pop():
removes 20
q1 = [10]

isEmpty():
false
*/
