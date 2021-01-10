package com.base.data;

/**
 * 单向链表
 *
 * @author An Qi
 * @date 2020/5/21
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

}
