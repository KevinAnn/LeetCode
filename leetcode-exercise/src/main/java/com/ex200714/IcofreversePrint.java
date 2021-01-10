package com.ex200714;

import com.base.data.ListNode;

import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * 题解：
 * 思路1：将链表压入栈中，之后栈中元素弹出到数组里，利用栈后入先出特性
 * 思路2：遍历链表节点获取链表长度，创建相同长度数组，从链表头节点开始将元素倒序放入数组
 *
 * @author An Qi
 * @date 2020/7/14
 */
public class IcofreversePrint {

    public static void main(String[] args) {

    }

    /**
     * 1.将链表从头节点开始压入栈中
     * 2.从栈中将链表元素值弹出到数组中
     *
     * @param head 头节点
     */
    public static int[] reversePrint(ListNode head) {
        ListNode point = head;
        Stack<ListNode> stack = new Stack<>();
        while (point != null) {
            stack.push(point);
            point = point.next;
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }

}
