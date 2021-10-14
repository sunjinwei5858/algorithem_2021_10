package com.sunjinwei.tree;

import com.sunjinwei.domain.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 */
public class BstLowCommonAncestor {

    /**
     * 思路：
     * 1.因为bst是有序的
     * 情况1：root>p1 && root <p2 那么root就是最近公共祖先
     * 情况2：root>p1 && root>p2 那么往root的左子树上递归
     * 情况3：root<p1 && root<p2 那么往root的右子树上递归
     *
     * @param root
     * @param p1
     * @param p2
     * @return
     */
    public TreeNode bstLowCommonAncestor(TreeNode root, TreeNode p1, TreeNode p2) {
        // base case
        if (root == null) {
            return null;
        }
        // 情况1
        if (root.val > p1.val && root.val > p2.val) {
            return bstLowCommonAncestor(root.left, p1, p2);
        }
        // 情况2
        if (root.val < p1.val && root.val < p2.val) {
            return bstLowCommonAncestor(root.right, p1, p2);
        }
        // 情况3
        return root;
    }
}
