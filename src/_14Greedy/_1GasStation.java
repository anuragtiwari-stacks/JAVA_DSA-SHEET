package _14Greedy;

public class _1GasStation
{
    /*
    LOGIC:
    ------
    Problem:
    Circular route hai with gas stations.
    gas[i]  = gas available at station i
    cost[i] = gas required to go from station i to i+1

    Hume ek aisa starting index return karna hai
    jahan se poora circle complete ho sake.
    Agar possible na ho → return -1.

    Key Observations:
    1. Agar totalGas < totalCost → answer impossible.
    2. Greedy approach use karte hain:
       - currentTank maintain karo.
       - agar currentTank < 0 ho jaaye:
         → matlab current start invalid hai
         → next station ko new start bana do
         → currentTank reset karo.
    3. End me start index hi answer hoga.
    */

    public static int canCompleteCircuit(int[] gas, int[] cost)
    {
        int totalGas = 0;
        int totalCost = 0;
        int currentTank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++)
        {
            totalGas = totalGas + gas[i];
            totalCost = totalCost + cost[i];

            currentTank = currentTank + gas[i] - cost[i];

            if (currentTank < 0)
            {
                start = i + 1;
                currentTank = 0;
            }
        }

        if (totalGas < totalCost)
        {
            return -1;
        }

        return start;
    }

    public static void main(String[] args)
    {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        System.out.println(canCompleteCircuit(gas, cost));
    }
}

/*
DRY RUN:
--------

Input:
gas  = [1, 2, 3, 4, 5]
cost = [3, 4, 5, 1, 2]

Initial:
totalGas = 0
totalCost = 0
currentTank = 0
start = 0

--------------------
i = 0
--------------------
totalGas = 1
totalCost = 3
currentTank = 1 - 3 = -2

currentTank < 0
→ start = 1
→ currentTank = 0

--------------------
i = 1
--------------------
totalGas = 3
totalCost = 7
currentTank = 2 - 4 = -2

currentTank < 0
→ start = 2
→ currentTank = 0

--------------------
i = 2
--------------------
totalGas = 6
totalCost = 12
currentTank = 3 - 5 = -2

currentTank < 0
→ start = 3
→ currentTank = 0

--------------------
i = 3
--------------------
totalGas = 10
totalCost = 13
currentTank = 4 - 1 = 3

--------------------
i = 4
--------------------
totalGas = 15
totalCost = 15
currentTank = 3 + (5 - 2) = 6

Loop ends

Check:
totalGas == totalCost ✔

FINAL ANSWER:
-------------
start index = 3
*/
