package _10Tries;

import java.util.*;

public class _1ReplaceWords
{

    static class TrieNode
    {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root = new TrieNode();

    // Step 1: Insert roots
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

        node.isEnd = true;
    }

    // Step 2: Replace word if root found
    private String getRoot(String word)
    {
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray())
        {
            int idx = c - 'a';

            // pehla match hi nahi hua
            if (node.children[idx] == null)
            {
                return word;
            }

            sb.append(c);
            node = node.children[idx];

            // jaha root khatam, wahi replace
            if (node.isEnd)
            {
                return sb.toString();
            }
        }

        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence)
    {
        // Trie create + insert
        for (String root : dictionary)
        {
            insert(root);
        }

        StringBuilder result = new StringBuilder();

        for (String word : sentence.split(" "))
        {
            result.append(getRoot(word)).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args)
    {
        _1ReplaceWords obj = new _1ReplaceWords();

        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";

        System.out.println(obj.replaceWords(dict, sentence));
    }
}
