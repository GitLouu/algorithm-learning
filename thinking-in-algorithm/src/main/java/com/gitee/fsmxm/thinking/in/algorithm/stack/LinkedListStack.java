package com.gitee.fsmxm.thinking.in.algorithm.stack;

import com.gitee.fsmxm.thinking.in.algorithm.DNode;

/**
 * 链表(式)栈
 * @param <T>
 */
public class LinkedListStack<T> implements IStack<T> {

    private final int capacity;
    private DNode<T> pos;
    private int size;

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
        // dummy node 哨兵
        this.pos = new DNode<T>(null);
    }

    public boolean add(T val) {
        if (size >= capacity) {
            return false;
        }
        DNode<T> temp = new DNode<T>(val);
        temp.prev = this.pos;
        this.pos.next = temp;
        this.pos = temp;
        size++;
        return true;
    }

    public T pop() {
        if (size < 1) {
            return null;
        }
        T val = this.pos.val;
        this.pos = this.pos.prev;
        this.pos.next = null;
        size--;
        return val;
    }

    public static void main(String[] args) {
        IStack<String> stack = new LinkedListStack<String>(5);
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
