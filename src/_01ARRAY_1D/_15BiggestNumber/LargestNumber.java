package _01ARRAY_1D._15BiggestNumber;

public class LargestNumber
{
    public static String largestNumber(int[] arr)
    {
        //Converting array to string b/c --> we need to concatenate and compare
        String[] StrArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            StrArr[i] = String.valueOf(arr[i]);
        }

        // Bubble sort using string comparison
        for (int i = 0; i < StrArr.length - 1; i++)
        {
            for (int j = 0; j < StrArr.length - 1 - i; j++)
            {
                String order1 = StrArr[j] + StrArr[j + 1];
                String order2 = StrArr[j + 1] + StrArr[j];
                if (order1.compareTo(order2) < 0)
                {
                    // Swap
                    String temp = StrArr[j];
                    StrArr[j] = StrArr[j + 1];
                    StrArr[j + 1] = temp;
                }
            }
        }

        // Handle case where all numbers are 0
        if (StrArr[0].equals("0"))
        {
            return "0";
        }

        // Join all strings
        String result = "";
        for (String s : StrArr)
        {
            result = result + s;
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));  // Output: 9534330
    }
}

/*
| Pass (i) | Comparison (j) | Compare Pair | order1 | order2 | Swap? | Resulting Array              |
| -------: | -------------- | ------------ | ------ | ------ | ----- | ---------------------------- |
|        0 | 0              | ("3", "30")  | 330    | 303    | No    | \["3", "30", "34", "5", "9"] |
|        0 | 1              | ("30", "34") | 3034   | 3430   | Yes   | \["3", "34", "30", "5", "9"] |
|        0 | 2              | ("30", "5")  | 305    | 530    | Yes   | \["3", "34", "5", "30", "9"] |
|        0 | 3              | ("30", "9")  | 309    | 930    | Yes   | \["3", "34", "5", "9", "30"] |
|        1 | 0              | ("3", "34")  | 334    | 343    | Yes   | \["34", "3", "5", "9", "30"] |
|        1 | 1              | ("3", "5")   | 35     | 53     | Yes   | \["34", "5", "3", "9", "30"] |
|        1 | 2              | ("3", "9")   | 39     | 93     | Yes   | \["34", "5", "9", "3", "30"] |
|        2 | 0              | ("34", "5")  | 345    | 534    | Yes   | \["5", "34", "9", "3", "30"] |
|        2 | 1              | ("34", "9")  | 349    | 934    | Yes   | \["5", "9", "34", "3", "30"] |
|        3 | 0              | ("5", "9")   | 59     | 95     | Yes   | \["9", "5", "34", "3", "30"] |
*/