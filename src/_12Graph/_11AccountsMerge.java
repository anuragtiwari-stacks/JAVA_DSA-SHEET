package _12Graph;

import java.util.*;

public class _11AccountsMerge
{
    public static List<List<String>> accountsMerge(List<List<String>> accounts)
    {
        // Graph: email -> connected emails
        Map<String, Set<String>> graph = new HashMap<>();

        // Email -> name
        Map<String, String> emailToName = new HashMap<>();

        // Step 1: Build graph
        for (List<String> acc : accounts)
        {
            String name = acc.get(0);

            for (int i = 1; i < acc.size(); i++)
            {
                String email = acc.get(i);
                emailToName.put(email, name);

                graph.putIfAbsent(email, new HashSet<>());

                // connect with previous email
                if (i > 1)
                {
                    String prev = acc.get(i - 1);
                    graph.get(email).add(prev);
                    graph.get(prev).add(email);
                }
            }
        }

        // Step 2: BFS to find connected components
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String email : graph.keySet())
        {
            if (!visited.contains(email))
            {
                List<String> component = new ArrayList<>();
                Queue<String> queue = new LinkedList<>();

                queue.add(email);
                visited.add(email);

                while (!queue.isEmpty())
                {
                    String curr = queue.poll();
                    component.add(curr);

                    for (String nei : graph.get(curr))
                    {
                        if (!visited.contains(nei))
                        {
                            visited.add(nei);
                            queue.add(nei);
                        }
                    }
                }

                // sort emails
                Collections.sort(component);

                // add name at start
                component.add(0, emailToName.get(email));
                result.add(component);
            }
        }

        return result;
    }

    // Driver for IDE
    public static void main(String[] args)
    {
        List<List<String>> accounts = new ArrayList<>();

        accounts.add(Arrays.asList(
                "John", "johnsmith@mail.com", "john_newyork@mail.com"));

        accounts.add(Arrays.asList(
                "John", "johnsmith@mail.com", "john00@mail.com"));

        accounts.add(Arrays.asList(
                "Mary", "mary@mail.com"));

        accounts.add(Arrays.asList(
                "John", "johnnybravo@mail.com"));

        System.out.println(accountsMerge(accounts));
    }
}

/*
Input:
[
 ["John", a, b],
 ["John", a, c],
 ["Mary", d],
 ["John", e]
]

Graph:
a <-> b
a <-> c
d (alone)
e (alone)

--------------------------------
Start BFS from 'a'
component = [a, b, c]
sorted = [a, b, c]
add name → ["John", a, b, c]

--------------------------------
Next unvisited: d
component = [d]
→ ["Mary", d]

--------------------------------
Next unvisited: e
component = [e]
→ ["John", e]

--------------------------------
Final Output:
[
 ["John", a, b, c],
 ["Mary", d],
 ["John", e]
]
*/
