package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 1472. 设计浏览器历史记录
 * https://leetcode-cn.com/problems/design-browser-history/
 * 难度 中等
 */
public class _1472_DesignBrowserHistory_Stack {

    /**
     * 双栈有点繁杂; 主要是要记录当前打开的网站
     */
    // solution
    static class BrowserHistory {

        final BHStack back;
        final BHStack forward;
        String currPage;

        public BrowserHistory(String homepage) {
            back = new BHStack(5000);
            forward = new BHStack(5000);
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

        static class BHStack {
            private final int capacity;
            private int size;
            private String[] data;

            public BHStack (int capacity) {
                this.capacity = capacity;
                this.data = new String[capacity];
            }

            public boolean add(String val) {
                if (size >= capacity) {
                    return false;
                }
                this.data[size] = val;
                size++;
                return true;
            }

            public String pop() {
                if (size < 1) {
                    return null;
                }
                return data[--size];
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public void removeAll() {
                this.data = new String[capacity];
                size = 0;
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
