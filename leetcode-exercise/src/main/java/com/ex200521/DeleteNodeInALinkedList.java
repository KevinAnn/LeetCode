package com.ex200521;

import com.base.data.ListNode;

/**
 * 237-删除链表中的节点
 *
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 现有一个链表 -- head = [4,5,1,9]
 * 示例 1:
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * @author An Qi
 * @date 2020/5/21
 */
public class DeleteNodeInALinkedList {

    public static void main(String[] args) {
    }

    /**
     * 此问题在于怎么处理需删除节点node，因为无法获取到前一个节点的指针，只能将后继节点的val和next覆盖当前节点
     */
    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
