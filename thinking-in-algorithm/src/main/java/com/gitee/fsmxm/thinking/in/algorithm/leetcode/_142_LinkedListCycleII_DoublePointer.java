package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 难度 中等
 */
public class _142_LinkedListCycleII_DoublePointer {

    // 快慢指针法
    // 一个指针走2步 一个指针走1步
    // 如果有环，指针无法走到结尾（会一直循环），则两个指针会相遇
    // 此时，再构建一个慢指针从头开始走，当两个慢指针相遇，则找到环入口
    // 时间复杂度O(n) 空间复杂度O(1)
    static class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode collisionNode = getCollisionNode(head);

            if (collisionNode == null) {
                return null;
            }

            ListNode curr = head;
            while (curr != collisionNode) {
                curr = curr.next;
                collisionNode = collisionNode.next;
            }
            return collisionNode;
        }

        private ListNode getCollisionNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return slow;
                }
            }
            return null;
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
        System.out.println(solution.detectCycle(h1));
        h4.next = h1;
        System.out.println(solution.detectCycle(h1));
        System.out.println(h1);
    }
}
