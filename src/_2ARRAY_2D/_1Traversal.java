package _2ARRAY_2D;

public class _1Traversal
{
    public static void main(String[] args)
    {
        // Declare and initialize a 2D array
        int[][] array = {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}};

        System.out.println("Traversal using normal for loop:");
        for (int i = 0; i < array.length; i++) // array.length gives the number of rows in the 2D array
        {
            System.out.print("{ ");
            for (int j = 0; j < array[i].length; j++) // array[i].length gives the number of columns in the i-th row
            {
                System.out.print(array[i][j]);
                if (j < array[i].length - 1)
                {
                    System.out.print(", ");
                }
            }
            System.out.println(" }");
        }

        System.out.println("\nTraversal using for-each loop:");
        for (int[] row : array)
        {
            System.out.print("{ ");
            for (int value : row)
            {
                System.out.print(value);
                if (value != row[row.length - 1])
                {
                    System.out.print(", ");
                }
            }
            System.out.println(" }");
        }
    }
}
