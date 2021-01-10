package com.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.base.data.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {

    public static void print(Object o) {
        System.out.println(JSON.toJSONString(o, SerializerFeature.WriteDateUseDateFormat));
    }

    /**
     * 构建列表
     * @param arr 数组
     * @return 列表头结点
     */
    public static ListNode buildListNode(int[] arr) {
        if (arr == null) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 打印链表
     * @param head 头结点
     * @return 链表字符串
     */
    public static void printListNode(ListNode head) {
        if (head == null) {
            print("");
        }
        StringBuilder str = new StringBuilder(String.valueOf(head.val));
        List<Integer> list = new ArrayList<>();
        recursionListNode(head, list);
        for (int i = list.size() - 1; i >= 0; i--) {
            str.append(" > ").append(list.get(i));
        }
        System.out.println(str);
    }

    private static void recursionListNode(ListNode node, List<Integer> list) {
        if (node.next == null) {
            return;
        }
        recursionListNode(node.next, list);
        list.add(node.next.val);
    }

}
