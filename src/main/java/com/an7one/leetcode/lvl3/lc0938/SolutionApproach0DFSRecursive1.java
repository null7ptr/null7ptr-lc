/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * a top-down approach
 * 
 * References:
 *  https://leetcode.com/problems/range-sum-of-bst/discuss/192019/JavaPython-3-3-similar-recursive-and-1-iterative-methods-w-comment-and-analysis.
 */
package com.an7one.leetcode.lvl3.lc0938;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive1 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null || L > R)
            return 0;

        int sum = 0;
        if (root.val > L)
            sum += rangeSumBST(root.left, L, R);

        if (root.val < R)
            sum += rangeSumBST(root.right, L, R);

        if (root.val >= L && root.val <= R)
            sum += root.val;

        return sum;
    }
}