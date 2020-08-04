package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 难度 简单
 */
public class _232_ImplementQueueUsingStacks {

    static class MyQueue {

        private final Stack<Integer> in;
        private final Stack<Integer> out;

        /** Initialize your data structure here. */
        public MyQueue() {
             in = new Stack<>();
             out = new Stack<>();
        }

        /** Push element x to the back of queue. */
        // T(n)=O(n)
        public void push(int x) {
            in.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        // T(n)=O(1) 摊还时间复杂度
        public int pop() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        /** Get the front element. */
        // T(n)=O(1) 摊还时间复杂度
        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

}
