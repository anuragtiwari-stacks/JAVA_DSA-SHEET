package _08Heap_Hashing;

import java.util.*;

// 3945. Digit Frequency Score
public class _5DigitFrequencyScore
{
    public int digitFrequencyScore(int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        while(n > 0)
        {
            int digit = n % 10;

            if(!map.containsKey(digit))
            {
                map.put(digit, 1);
            }
            else
            {
                map.put(digit, map.get(digit) + 1);
            }

            n = n / 10;
        }

        int ans = 0;

        for(int key : map.keySet())
        {
            ans = ans + key * map.get(key);
        }

        return ans;
    }

    public static void main(String[] args)
    {
        _5DigitFrequencyScore obj = new _5DigitFrequencyScore();

        int n = 122333;

        int result = obj.digitFrequencyScore(n);

        System.out.println("Digit Frequency Score = " + result);
    }
}