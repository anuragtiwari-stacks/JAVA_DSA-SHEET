package _01ARRAY_1D._9Repeat_and_Missing;
import java.util.HashSet;

public class _9DuplicateNumber
{
    public static void printDuplicates(int[] nums)
    {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int num : nums)
        {
            if (visited.contains(num))
            {
                duplicates.add(num);
            }
            else
            {
                visited.add(num);
            }
        }

        if (duplicates.isEmpty())
        {
            System.out.println("No duplicates found.");
        }
        else
        {
            System.out.print("Duplicate elements: ");
            for (int dup : duplicates)
            {
                System.out.print(dup + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 3, 4, 2, 5, 3, 6, 1 };

        printDuplicates(nums);
    }
}

