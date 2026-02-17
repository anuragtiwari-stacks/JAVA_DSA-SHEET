package _15BitManipulation;

/*
LeetCode 401
Binary Watch
*/

import java.util.*;

public class _1BinaryWatch
{

    public List<String> readBinaryWatch(int turnedOn)
    {
        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++)
        {
            for (int minute = 0; minute < 60; minute++)
            {
                /*
                 Integer.bitCount(x)
                 → Counts number of 1s in binary representation of x.

                 Example:
                 hour = 3  → binary = 11 → bitCount = 2
                 minute = 5 → binary = 101 → bitCount = 2
                */

                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn)
                {
                    /*
                     String.format("%d:%02d", hour, minute)

                     %d     → prints hour normally
                     %02d   → prints minute in 2 digits
                               If minute = 5 → prints 05
                               If minute = 12 → prints 12

                     Example:
                     hour = 3, minute = 5
                     Output → "3:05"
                    */

                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        _1BinaryWatch obj = new _1BinaryWatch();

        System.out.println(obj.readBinaryWatch(1));
    }
}
