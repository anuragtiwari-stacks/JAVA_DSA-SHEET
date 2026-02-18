package _15BitManipulation;

/*
LeetCode 693
Binary Number with Alternating Bits
*/

import java.util.*;

public class _2AlternatingBits
{

    public boolean hasAlternatingBits(int n)
    {
        /*
         Step 1:
         Convert decimal number to binary string
         Example:
         n = 5
         Binary = "101"
        */

        String binary = Integer.toBinaryString(n);

        int len = binary.length();

        /*
         Step 2:
         Check adjacent bits

         If any two adjacent bits are same
         → Not alternating
         → Return false
        */

        for(int i = 0; i < len - 1; i++)
        {
            if(binary.charAt(i) == binary.charAt(i + 1))
            {
                return false;
            }
        }

        /*
         If loop completes
         → All bits are alternating
        */

        return true;
    }

    public static void main(String[] args)
    {
        _2AlternatingBits obj = new _2AlternatingBits();

        System.out.println(obj.hasAlternatingBits(5));  // true
        System.out.println(obj.hasAlternatingBits(7));  // false
    }
}
