package _6BinarySearchTree;

public class _10ConflictingAppointments
{
    // Interval class
    static class Interval
    {
        int start, end;

        Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    // Check if two intervals overlap
    public static boolean isConflicting(Interval a, Interval b)
    {
        return a.start < b.end && b.start < a.end;
    }

    // Find and print all conflicting appointments
    public static void findConflicts(Interval[] appointments)
    {
        int n = appointments.length;

        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (isConflicting(appointments[i], appointments[j]))
                {
                    System.out.println("[" + appointments[i].start + "," + appointments[i].end + "] conflicts with [" + appointments[j].start + "," + appointments[j].end + "]");
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Interval[] appointments = new Interval[]
                {
                        new Interval(1, 5),
                        new Interval(3, 7),
                        new Interval(2, 6),
                        new Interval(10, 15),
                        new Interval(5, 6),
                        new Interval(4, 100)
                };

        System.out.println("Conflicting Appointments:");
        findConflicts(appointments);
    }
}
