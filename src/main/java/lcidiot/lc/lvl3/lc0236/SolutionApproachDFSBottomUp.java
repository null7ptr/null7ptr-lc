/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
package main.java.lcidiot.lc.lvl3.lc0236;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
}