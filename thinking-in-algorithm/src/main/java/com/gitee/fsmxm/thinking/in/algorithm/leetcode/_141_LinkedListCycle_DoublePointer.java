package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 难度 简单
 */
public class _141_LinkedListCycle_DoublePointer {

    // 快慢指针法
    // 一个指针走2步 一个指针走1步
    // 如果有环，指针无法走到结尾（会一直循环），则两个指针会相遇
    // 时间复杂度O(n) 空间复杂度O(1)
    static class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(h1));
        h4.next = h2;
        System.out.println(solution.hasCycle(h1));
    }
}
