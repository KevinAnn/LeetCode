package com.base.data;

/**
 * 二叉树
 *
 * @author An Qi
 * @date 2020/7/14
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public void setNode(TreeNode l, TreeNode r) {
        this.left = l;
        this.right = r;
    }
}
