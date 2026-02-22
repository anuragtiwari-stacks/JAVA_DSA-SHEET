package _15BitManipulation;

// Leetcode: 868
public class _4MaxBinaryGapCount
{
    public static int binaryGap(int n)
    {
        String binary = Integer.toBinaryString(n);
        int len = binary.length();

        int maxLength = 0;

        for(int i = 0; i < len; i++)
        {
            if(binary.charAt(i) == '1')
            {
                for(int j = i + 1; j < len; j++)
                {
                    if(binary.charAt(j) == '1')
                    {
                        int length = j - i;
                        maxLength = Math.max(maxLength, length);
                        i = j - 1;   // move i to just before j (outer loop i++ karega)
                        break;
                    }
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args)
    {
        int n = 22;

        int result = binaryGap(n);

        System.out.println("Maximum Binary Gap = " + result);
    }
}

/*
DRY RUN

Input:
n = 22

Binary Representation:
22 -> 10110
Index:  0 1 2 3 4

---------------------------------
i = 0
binary[0] = '1'

Inner loop:
j = 1 -> '0'
j = 2 -> '1'

length = 2 - 0 = 2
maxLength = 2
i = 2 - 1 = 1

---------------------------------
Outer loop i++ → i = 2
binary[2] = '1'

Inner loop:
j = 3 -> '1'

length = 3 - 2 = 1
maxLength = max(2,1) = 2
i = 3 - 1 = 2

---------------------------------
Outer loop i++ → i = 3
binary[3] = '1'

Inner loop:
j = 4 -> '0'
(no next '1')

---------------------------------

Final Answer:
Maximum Binary Gap = 2

=================================================
*/