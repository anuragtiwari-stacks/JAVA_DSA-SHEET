package _1ARRAY_1D._12ProductOfArrayExceptSelf;

import java.util.Scanner;

public class ProductExceptSelf
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input the number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Step 2: Input array elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }

        // Step 3: Create result array
        int[] ans = new int[n];

        // Step 4: For each element, calculate product of all other elements
        for (int i = 0; i < n; i++)
        {
            int prod = 1;

            for (int j = 0; j < n; j++)
            {
                if (i != j)
                {
                    prod *= nums[j]; // multiply all except nums[i]
                }
            }

            ans[i] = prod;
        }

        // Step 5: Print result array
        System.out.println("Product of array except self:");
        for (int i = 0; i < n; i++)
        {
            System.out.print(ans[i] + " ");
        }
    }
}

