package _3STRING;

public class _2LexicographicalSort
{
    public static void main(String[] args)
    {
        String[] arr = {"banana", "apple", "grape", "cherry", "mango"};

        /*
         Dry Run:
         Initial array:
         [banana, apple, grape, cherry, mango]

         i = 0
           j = 1 → compare "banana" with "apple"
                 "banana" > "apple" → swap
                 [apple, banana, grape, cherry, mango]

           j = 2 → compare "apple" with "grape"
                 no swap
           j = 3 → compare "apple" with "cherry"
                 no swap
           j = 4 → compare "apple" with "mango"
                 no swap
         Smallest element "apple" fixed at index 0

         i = 1
           j = 2 → compare "banana" with "grape"
                 no swap
           j = 3 → compare "banana" with "cherry"
                 no swap
           j = 4 → compare "banana" with "mango"
                 no swap
         "banana" fixed at index 1

         i = 2
           j = 3 → compare "grape" with "cherry"
                 "grape" > "cherry" → swap
                 [apple, banana, cherry, grape, mango]

           j = 4 → compare "cherry" with "mango"
                 no swap
         "cherry" fixed at index 2

         i = 3
           j = 4 → compare "grape" with "mango"
                 no swap

         Final sorted array:
         [apple, banana, cherry, grape, mango]
        */

        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i].compareTo(arr[j]) > 0)
                {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("Lexicographically sorted strings:");
        for (String s : arr)
        {
            System.out.println(s);
        }
    }
}
