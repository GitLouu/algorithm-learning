package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 难度 中等
 */
public class _142_LinkedListCycleII_HashSetCollisionDetection {

    // 哈希表碰撞检测
    // 时间复杂度O(n) 空间复杂度O(n)
    static class Solution {
        Set<ListNode> set = new HashSet<ListNode>();
        public ListNode detectCycle(ListNode head) {

            if (head == null) {
                return null;
            }

            ListNode curr = head;
            while (curr != null) {
                if (set.contains(curr)) {
                    return curr;
                }
                set.add(curr);
                curr = curr.next;
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
