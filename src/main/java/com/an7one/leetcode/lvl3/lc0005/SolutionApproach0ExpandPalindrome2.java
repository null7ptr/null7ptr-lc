package com.an7one.leetcode.lvl3.lc0005;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * <p>
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * https://leetcode.com/problems/longest-palindromic-substring/discuss/2928/Very-simple-clean-java-solution/3700
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0ExpandPalindrome2 {
    public String longestPalindrome(String str) {
        // sanity check
        if (str == null || str.length() < 2)
            return str;

        final int L = str.length();

        String longest = "";
        for (int i = 0; i < L; ++i) {
            String str1 = expand(i, i, str);
            String str2 = expand(i, i + 1, str);

            if (str1.length() > longest.length())
                longest = str1;
            if (str2.length() > longest.length())
                longest = str2;
        }

        return longest;
    }

    private String expand(int lo, int hi, String str) {
        final int L = str.length();
        while (lo >= 0 && hi < L) {
            if (str.charAt(lo) != str.charAt(hi))
                break;
            --lo;
            ++hi;
        }

        return str.substring(lo + 1, hi);
    }
}