package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    void printAll() {
        StringBuilder builder = new StringBuilder();
        ListNode h = this;
        builder.append(h.val).append(" -> ");
        while (h.next != null) {
            builder.append(h.next.val).append(" -> ");
            h = h.next;
        }
        System.out.println(builder.append("NULL").toString());
    }
}