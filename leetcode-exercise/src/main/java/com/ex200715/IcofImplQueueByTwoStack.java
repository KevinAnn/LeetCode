package com.ex200715;

import com.util.Util;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 解题思路：
 * 一个栈接收元素，当需要获取的时候如果s2元素不为空则将s1的元素pop到s2中，从s2中获取元素
 *
 * @author An Qi
 * @date 2020/7/15
 */
public class IcofImplQueueByTwoStack {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1).appendTail(2).appendTail(3);
        cQueue.deleteHead();
        cQueue.deleteHead();
        cQueue.deleteHead();
        Util.print(cQueue.deleteHead());
    }


    static class CQueue{

        Stack<Integer> s1;
        Stack<Integer> s2;

        public CQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public CQueue appendTail(int value) {
            s1.push(value);
            return this;
        }

        public int deleteHead() {
            if (s2.isEmpty()) {
                if (s1.isEmpty()) {
                    return -1;
                }
                while (s1.size() > 0) {
                    s2.push(s1.pop());
                }
                return s2.pop();
            }
            return s2.pop();
        }

    }

}
