package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 难度 简单
 */
public class _206_ReverseLinkedList_Recursion {

    // 使用递归
    // 时间复杂度O(n) 空间复杂度O(n)
    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }
    }

    public static void main(String[] args) {
        // 输入: 1->2->3->4->5->NULL
        // 输出: 5->4->3->2->1->NULL
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        System.out.print("输入: ");
        h1.printAll();
        System.out.print("输出: ");
        ListNode newNode = new Solution().reverseList(h1);
        newNode.printAll();
    }

}
