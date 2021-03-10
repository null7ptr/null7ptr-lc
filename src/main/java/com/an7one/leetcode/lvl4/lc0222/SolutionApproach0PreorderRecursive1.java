/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * 
 * Time Complexity:     O(lg(N) ^ 2)
 * Space Complexity:    O(lg(N))
 * 
 * the subtree of a complete binary tree also is a complete binary tree
 * 
 * References:
 *  https://leetcode.com/problems/count-complete-tree-nodes/discuss/61953/Easy-short-c%2B%2B-recursive-solution
 */
package com.an7one.leetcode.lvl4.lc0222;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive1 {
    public int countNodes(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;

        int leftHeight = 0, rightHeight = 0;

        TreeNode left = root, right = root;
        while (left != null) {
            ++leftHeight;
            left = left.left;
        }

        while (right != null) {
            ++rightHeight;
            right = right.right;
        }

        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}