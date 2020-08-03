package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.HashSet;

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 难度 简单
 */
public class _141_LinkedListCycle_HashSetCollisionDetection {

    // 哈希表碰撞检测
    // 时间复杂度O(n) 空间复杂度O(1)
    static class Solution {
        HashSet<ListNode> set = new HashSet<ListNode>();
        public boolean hasCycle(ListNode head) {
            ListNode curr = head;
            set.add(curr);
            while (curr.next != null) {
                if (set.contains(curr.next)) {
                    return true;
                }
                set.add(curr.next);
                curr = curr.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(h5));
        h5.next = h1;
        System.out.println(solution.hasCycle(h5));
    }
}
