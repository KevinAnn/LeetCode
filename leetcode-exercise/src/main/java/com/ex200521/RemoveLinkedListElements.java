package com.ex200521;

import com.util.ListNode;
import com.util.Util;

/**
 * 203-移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author An Qi
 * @date 2020/5/21
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, null)))));
        int val = 6;
        Util.print(removeElements(head, 6));
    }

    /**
     * 双指针
     */
    private static ListNode removeElements(ListNode head, int val) {
        // 使用哨兵节点，避免对头节点的特殊处理
        ListNode sentinel = new ListNode(0, head);
        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                // 删除元素，将后继节点的指针指向前驱节点
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }


}
