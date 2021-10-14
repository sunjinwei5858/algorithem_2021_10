package com.sunjinwei.tree;

import com.sunjinwei.domain.TreeNode;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * 二叉树最近公共祖先
 */
public class LowCommonAncestor {

    /**
     * 思路：
     * 1. 公共祖先也可以是自己
     * 2. 公共祖先可以为null
     *
     * @param root
     * @param p1
     * @param p2
     * @return
     */
    public TreeNode lowCommonAncestor(TreeNode root, TreeNode p1, TreeNode p2) {
        // base case1
        if (root == null) {
            return null;
        }
        // base case2
        if (root == p1 || root == p2) {
            return root;
        }

        // 后序遍历
        // 左子树
        TreeNode l = lowCommonAncestor(root.left, p1, p2);
        // 右子树
        TreeNode r = lowCommonAncestor(root.right, p1, p2);

        // 如果都为null
        if (l == null && r == null) {
            return null;
        }
        // 如果p和q都不为null
        if (l != null && r != null) {
            return root;
        }
        // 如果只有其中一个为null
        return l != null ? l : r;
    }
}
