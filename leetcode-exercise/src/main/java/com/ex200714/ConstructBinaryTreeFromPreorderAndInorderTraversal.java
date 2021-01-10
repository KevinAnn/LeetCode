package com.ex200714;

import com.base.data.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树 / 剑指 Offer 07. 重建二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author An Qi
 * @date 2020/7/14
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        // 使用map存储中序遍历数组中每个元素的位置，方便获取到根节点位置和左右子树的长度
        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, map, 0, preorder.length - 1, 0, inorder.length - 1);

    }

    private static TreeNode buildTree(int[] preorder, Map<Integer, Integer> map, int preLeft, int preRight, int inLeft, int inRight) {
        // 终止条件：前序、中序数组元素已用完
        // 此时的根节点返回未空
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        // 根节点
        int root = preorder[preLeft];
        TreeNode treeNode = new TreeNode(root);

        int rootIndex = map.get(root);
        // 左叶子节点
        treeNode.left = buildTree(preorder, map, preLeft + 1, preLeft + rootIndex - inLeft, inLeft, rootIndex - 1);

        // 右叶子节点
        treeNode.right = buildTree(preorder, map, preLeft + rootIndex - inLeft + 1, preRight, rootIndex + 1, inRight);

        return treeNode;
    }

}
