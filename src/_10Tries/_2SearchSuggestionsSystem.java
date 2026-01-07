package _10Tries;

import java.util.*;

public class _2SearchSuggestionsSystem
{

    static class TrieNode
    {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    private TrieNode root;

    public _2SearchSuggestionsSystem()
    {
        root = new TrieNode();
    }

    // NORMAL INSERT
    private void insert(String word)
    {
        TrieNode node = root;

        for (char c : word.toCharArray())
        {
            int idx = c - 'a';

            if (node.children[idx] == null)
            {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.isEndOfWord = true;
    }

    // DFS to collect first 3 lexicographically smallest words
    private void dfs(TrieNode node, String prefix, List<String> result)
    {
        if (result.size() == 3)
        {
            return;
        }

        if (node.isEndOfWord)
        {
            result.add(prefix);
        }

        for (int i = 0; i < 26; i++)
        {
            if (node.children[i] != null)
            {
                dfs(node.children[i], prefix + (char)(i + 'a'), result);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord)
    {
        // 🔥 STEP 1: sort FIRST
        Arrays.sort(products);

        // 🔥 STEP 2: insert normally
        for (String product : products)
        {
            insert(product);
        }

        List<List<String>> answer = new ArrayList<>();
        TrieNode node = root;
        String prefix = "";

        // 🔥 STEP 3: prefix search
        for (char c : searchWord.toCharArray())
        {
            prefix += c;
            int idx = c - 'a';

            if (node != null && node.children[idx] != null)
            {
                node = node.children[idx];
                List<String> temp = new ArrayList<>();
                dfs(node, prefix, temp);
                answer.add(temp);
            }
            else
            {
                node = null;
                answer.add(new ArrayList<>());
            }
        }

        return answer;
    }

    public static void main(String[] args)
    {
        _2SearchSuggestionsSystem obj =
                new _2SearchSuggestionsSystem();

        String[] products =
                {
                        "mobile",
                        "mouse",
                        "moneypot",
                        "monitor",
                        "mousepad"
                };

        String searchWord = "mouse";

        System.out.println(obj.suggestedProducts(products, searchWord));
    }
}
