package _14Greedy;

import java.util.Arrays;

public class _3DestroyingAsteroids
{

    /*
        🔗 LeetCode 2126 - Destroying Asteroids

        You are given an integer mass representing the initial mass
        of a planet.

        You are also given an integer array asteroids, where
        asteroids[i] is the mass of the ith asteroid.

        The planet can destroy an asteroid if:
        asteroid mass <= current planet mass

        After destroying an asteroid:
        current mass += asteroid mass

        Return true if all asteroids can be destroyed,
        otherwise return false.

        ---------------------------------------------------

        Example:

        Input:
        mass = 10
        asteroids = [3,9,19,5,21]

        Output:
        true
    */

    public static void main(String[] args)
    {

        int mass = 10;

        int[] asteroids = {3, 9, 19, 5, 21};

        Arrays.sort(asteroids);

        // Using long because mass keeps increasing
        // and can exceed int range during accumulation
        long currentMass = mass;

        for (int num : asteroids)
        {

            if (num > currentMass)
            {
                System.out.println(false);
                return;
            }

            currentMass = currentMass + num;
        }

        System.out.println(true);
    }
}