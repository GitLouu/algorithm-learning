package com.gitee.fsmxm.thinking.in.algorithm.stack;

import com.gitee.fsmxm.thinking.in.algorithm.DNode;

/**
 * 双向链表实现栈  链式栈
 * @param <T>
 */
public class DoublyLinkedListStack<T> implements IStack<T> {

    private final int capacity;
    private DNode<T> top;
    private int count;

    public DoublyLinkedListStack() {
        this(Integer.MAX_VALUE);
    }

    public DoublyLinkedListStack(int capacity) {
        this.capacity = capacity;
        // dummy node 哨兵
        this.top = new DNode<T>(null);
    }

    public boolean add(T val) {
        if (count >= capacity) {
            return false;
        }
        DNode<T> temp = new DNode<T>(val);
        temp.prev = this.top;
        this.top.next = temp;
        this.top = temp;
        count++;
        return true;
    }

    public T pop() {
        if (count < 1) {
            return null;
        }
        T val = this.top.val;
        this.top = this.top.prev;
        this.top.next = null;
        count--;
        return val;
    }

    public static void main(String[] args) {
        IStack<String> stack = new DoublyLinkedListStack<String>(5);
        stack.add("123");
        stack.add("456");
        stack.add("789");
        stack.add("abc");
        stack.add("def");
        stack.add("ghi");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.add("ghi");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.add("666");
        System.out.println(stack.pop());
    }
}
