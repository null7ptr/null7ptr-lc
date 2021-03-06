/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * 
 * Time Compleixties:
 *  `addWord`:  O(N * L)
 *  `search`:   O(N * L)
 *      N, number of calls of each funtion
 *  
 * Space Complexity:    O(N * L)
 */
package com.an7one.leetcode.lvl4.lc0211;

public class SolutionApproach0TrieWithDFS {
    private static final char PLACE_HOLDER = '.';
    private final TrieNode ROOT;

    /** Initialize your data structure here. */
    public SolutionApproach0TrieWithDFS() {
        this.ROOT = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = ROOT;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();

            node = node.children[idx];
        }

        node.word = word;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode node = ROOT;
        return dfs(word, 0, node);
    }

    private boolean dfs(String word, int idx, TrieNode node) {
        final int L = word.length();
        if (idx == L)
            return node.word != null;

        char ch = word.charAt(idx);
        if (ch != PLACE_HOLDER) {
            TrieNode child = node.children[ch - 'a'];
            if (child == null)
                return false;
            return dfs(word, idx + 1, child);
        } else {
            for (TrieNode child : node.children) {
                if (child == null)
                    continue;
                if (dfs(word, idx + 1, child)) {
                    return true;
                }
            }
        }

        return false;
    }

    private class TrieNode {
        protected TrieNode[] children;
        protected String word;

        protected TrieNode() {
            this.children = new TrieNode[26];
            this.word = null;
        }
    }
}
