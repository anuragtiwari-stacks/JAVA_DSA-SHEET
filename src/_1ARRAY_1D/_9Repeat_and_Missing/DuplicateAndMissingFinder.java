package _1ARRAY_1D._9Repeat_and_Missing;
import java.util.Scanner;

public class DuplicateAndMissingFinder
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Take array size input from user
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        int[] freq = new int[n + 1]; // Index from 1 to n

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
            freq[nums[i]]++; // Count frequency of each number
        }

        int duplicate = -1;
        int missing = -1;

        // Find the number that occurs twice and the one that is missing
        for (int i = 1; i <= n; i++)
        {
            if (freq[i] == 2)
            {
                duplicate = i;
            }
            else if (freq[i] == 0)
            {
                missing = i;
            }
        }

        System.out.println("Duplicate: " + duplicate);
        System.out.println("Missing: " + missing);
    }
}
