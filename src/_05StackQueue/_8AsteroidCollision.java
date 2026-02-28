package _05StackQueue;

import java.util.Stack;

public class _8AsteroidCollision
{
    /*
    LOGIC (Same as image):
    ---------------------
    - Stack use karte hain
    - Collision tab hoti hai jab:
      stack top > 0  AND  current < 0

    sum = current + stackTop

    sum < 0  → stack pop (current bada)
    sum > 0  → current destroy
    sum == 0 → dono destroy
    */

    public static int[] asteroidCollision(int[] asteroids)
    {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids)
        {
            while (!st.isEmpty() && a < 0 && st.peek() > 0) //condition for the collison
            {
                int sum = a + st.peek();

                if (sum < 0)
                {
                    st.pop();
                }
                else if (sum > 0)
                {
                    a = 0;  // 0 matlab destroy ho gya h or abb stack me push nhi kerna hoga
                }
                else
                {
                    st.pop();
                    a = 0;
                }
            }

            if (a != 0)
            {
                st.push(a);
            }
        }

        int[] result = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--)
        {
            result[i] = st.pop();
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] asteroids = {5, 10, -5};

        int[] ans = asteroidCollision(asteroids);

        for (int x : ans)
        {
            System.out.print(x + " ");
        }
    }
}

/*
DRY RUN:
--------

asteroids = [5, 10, -5]

stack = []

a = 5
push → [5]

a = 10
push → [5, 10]

a = -5
collision with 10
sum = -5 + 10 = 5 > 0
current destroyed

Final stack = [5, 10]

Output:
5 10
*/
