package com.gitee.fsmxm.thinking.in.algorithm.stack;

import com.gitee.fsmxm.thinking.in.algorithm.SNode;

/**
 * 单链表实现栈  链式栈
 * @param <T>
 */
public class SinglyLinkedListStack<T> implements IStack<T> {

    private final int capacity;
    private SNode<T> top;
    private int count;

    public SinglyLinkedListStack() {
        this(Integer.MAX_VALUE);
    }

    public SinglyLinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    public boolean add(T val) {
        if (count >= capacity) {
            return false;
        }

        SNode<T> temp = new SNode<T>(val);
        if (top != null) {
            temp.next = top;
        }
        top = temp;
        count++;
        return true;
    }

    public T pop() {
        if (count < 1) {
            return null;
        }
        T val = top.val;
        top = top.next;
        count--;
        return val;
    }

    public static void main(String[] args) {
        IStack<String> stack = new SinglyLinkedListStack<String>(5);
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
