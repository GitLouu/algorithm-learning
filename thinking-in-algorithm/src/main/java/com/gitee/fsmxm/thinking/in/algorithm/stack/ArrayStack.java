package com.gitee.fsmxm.thinking.in.algorithm.stack;

/**
 * 数组实现栈结构
 */
public class ArrayStack<T> implements IStack<T> {

    private final int capacity;
    private int size;
    private final T[] data;

    @SuppressWarnings("unchecked")
    public ArrayStack (int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
    }

    public boolean add(T val) {
        if (size >= capacity) {
            return false;
        }
        this.data[size] = val;
        size++;
        return true;
    }

    public T pop() {
        if (size < 1) {
            return null;
        }
        return data[--size];
    }


    public static void main(String[] args) {
        IStack<String> stack = new ArrayStack<String>(5);
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
