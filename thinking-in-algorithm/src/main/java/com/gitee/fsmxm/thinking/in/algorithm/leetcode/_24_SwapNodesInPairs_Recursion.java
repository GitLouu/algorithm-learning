package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 难度 中等
 */
public class _24_SwapNodesInPairs_Recursion {
    // 递归
    // 时间复杂度O(n) 空间复杂度O(n)
    static class Solution {

        public ListNode swapPairs(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode first = head;
            ListNode second = first.next;

            first.next = swapPairs(second.next);
            second.next = first;

            return second;
        }

    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        ListNode h6 = new ListNode(6);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        Solution solution = new Solution();
        ListNode listNode = solution.swapPairs(h1);
        listNode.printAll();
    }
}
