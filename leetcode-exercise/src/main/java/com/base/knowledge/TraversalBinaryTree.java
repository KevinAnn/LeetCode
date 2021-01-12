package com.base.knowledge;

import com.base.data.TreeNode;
import com.base.util.Util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

/**
 * 遍历二叉树
 *
 * @author An Qi
 * @date 2021/1/12
 */
public class TraversalBinaryTree {


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        n1.setNode(n2, n3);
        n2.setNode(n4, n5);
        n3.setNode(null, n6);
        n5.setNode(n7, n8);

        preOrderTraversal2(n1);
        Util.print(preOrderList);

        inOrderTraversal2(n1);
        Util.print(inOrderList);

        postOrderTraversal2(n1);
        Util.print(postOrderList);

        levelTraversal(n1);
        Util.print(levelList);
    }

    static List<Integer> preOrderList = new ArrayList<>();
    static List<Integer> inOrderList = new ArrayList<>();
    static List<Integer> postOrderList = new ArrayList<>();
    static List<Integer> levelList = new ArrayList<>();

    public static void preOrderTraversal(TreeNode node) {
        // 跳出点
        if (node != null) {
            preOrderList.add(node.val);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static void preOrderTraversal2(TreeNode node) {
        TreeNode n = node;
        LinkedList<TreeNode> queue = new LinkedList<>();
        while (n != null || !queue.isEmpty()) {
            if (n != null) {
                preOrderList.add(n.val);
                queue.push(n);
                n = n.left;
            } else {
                n = queue.pop().right;
            }
        }
    }


    public static void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            inOrderList.add(node.val);
            inOrderTraversal(node.right);
        }
    }

    public static void inOrderTraversal2(TreeNode node) {
        TreeNode n = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (n != null || !stack.isEmpty()) {
            if (n != null) {
                stack.push(n);
                n = n.left;
            } else {
                TreeNode temp = stack.pop();
                inOrderList.add(temp.val);
                n = temp.right;
            }
        }
    }

    public static void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            postOrderList.add(node.val);
        }
    }

    public static void postOrderTraversal2(TreeNode node) {
        TreeNode n = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (n != null || !stack.isEmpty()) {
            if (n != null) {
                stack.push(n);
                postOrderList.add(0, n.val);
                n = n.right;
            } else {
                TreeNode temp = stack.pop();
                n = temp.left;
            }
        }
    }

    public static void levelTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            levelList.add(tempNode.val);
            if (tempNode.left != null) {
                queue.offer(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.offer(tempNode.right);
            }
        }
    }
}
