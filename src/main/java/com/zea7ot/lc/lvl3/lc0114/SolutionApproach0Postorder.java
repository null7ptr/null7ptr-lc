/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * Time Complexity:     O()
 * Space Compleixty:    O()
 * 
 * 
 */
package com.zea7ot.lc.lvl3.lc0114;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Postorder {
    private TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        // sanity check
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        
        prev = root;
    }
}