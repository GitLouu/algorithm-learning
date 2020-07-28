package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 1472. 设计浏览器历史记录
 * https://leetcode-cn.com/problems/design-browser-history/
 * 难度 中等
 */
public class _1472_BrowserHistory_By2Stack {

    /**
     * 双栈有点繁杂; 主要是要记录当前打开的网站
     */
    // solution
    static class BrowserHistory {

        final BHStack back;
        final BHStack forward;
        String currPage;

        public BrowserHistory(String homepage) {
            back = new BHStack();
            forward = new BHStack();
            currPage = homepage;
        }

        public void visit(String url) {
            back.add(currPage);
            currPage = url;
            forward.removeAll();
        }

        public String back(int steps) {
            if (steps < 1 || back.isEmpty()) {
                return currPage;
            }
            forward.add(currPage);
            boolean first = true;
            while (steps-- > 0 && !back.isEmpty()) {
                if (!first) {
                    forward.add(currPage);
                }
                currPage = back.pop();
                if (first) {
                    first = false;
                }
            }
            return currPage;
        }

        public String forward(int steps) {
            if (steps < 1 || forward.isEmpty()) {
                return currPage;
            }
            back.add(currPage);
            boolean first = true;
            while (steps-- > 0 && !forward.isEmpty()) {
                if (!first) {
                    back.add(currPage);
                }
                currPage = forward.pop();
                if (first) {
                    first = false;
                }
            }
            return currPage;
        }

        class BHStack {
            final Node head;
            Node tail;

            public BHStack() {
                // dummy node
                head = new Node(null);
                tail = head;
            }

            public boolean add(String str) {
                Node temp = new Node(str);
                temp.prev = tail;
                tail.next = temp;
                tail = temp;
                return true;
            }

            public String pop() {
                if (tail == head) {
                    return null;
                }
                String val = tail.val;
                tail = tail.prev;
                tail.next = null;
                return val;
            }

            public boolean isEmpty() {
                return tail == head;
            }

            public void removeAll() {
                while (pop() != null) {
                }
            }

            class Node {
                String val;
                Node prev;
                Node next;

                public Node(String val) {
                    this.val = val;
                }
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
