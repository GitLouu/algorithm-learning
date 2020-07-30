package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 1472. 设计浏览器历史记录
 * https://leetcode-cn.com/problems/design-browser-history/
 * 难度 中等
 */
public class _1472_DesignBrowserHistory_DoublyLinkedList {

    /**
     * 双向链表代码简洁多了
     */
    // solution
    static class BrowserHistory {

        final Node head;
        Node cur;

        public BrowserHistory(String homepage) {
            // dummy node
            head = new Node(null);
            cur = new Node(homepage);
            head.next = cur;
            cur.prev = head;
        }

        public void visit(String url) {
            cur.next = new Node(url);
            cur.next.prev = cur;
            cur = cur.next;
        }

        public String back(int steps) {
            while (steps-- > 0 && cur.prev != head) {
                cur = cur.prev;
            }
            return cur.val;
        }

        public String forward(int steps) {
            while (steps-- > 0 && cur.next != null) {
                cur = cur.next;
            }
            return cur.val;
        }

        static class Node {
            String val;
            Node prev;
            Node next;

            public Node(String val) {
                this.val = val;
            }
        }

    }

    public static void main(String[] args) {

        //["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
        //[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        System.out.println();
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));

    }
}
