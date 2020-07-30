package com.gitee.fsmxm.thinking.in.algorithm.queue;

import com.gitee.fsmxm.thinking.in.algorithm.SNode;

/**
 * 单链表实现队列 （链式队列）
 */
public class SinglyLinkedListQueue<T> implements IQueue<T> {

    private final int capacity;
    private int count;
    private SNode<T> head;
    private SNode<T> tail;

    public SinglyLinkedListQueue() {
        this(Integer.MAX_VALUE);
    }

    public SinglyLinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    public boolean add(T val) {
        if (count >= capacity) {
            return false;
        }
        SNode<T> temp = new SNode<T>(val);
        if (tail == null) {
            head = temp;
            tail = head;
        } else {
            tail.next = temp;
            tail = temp;
        }
        count++;
        return true;
    }

    public T poll() {
        if (count < 1) {
            return null;
        }
        T val = head.val;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        count--;
        return val;
    }

    public static void main(String[] args) {
        IQueue<Integer> queue = new SinglyLinkedListQueue<Integer>(3);
        System.out.println(queue.poll());
        System.out.println();
        System.out.println(queue.add(1));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println();
        System.out.println(queue.add(2));
        System.out.println(queue.add(3));
        System.out.println(queue.add(4));
        System.out.println(queue.add(5));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println();
        System.out.println(queue.add(5));
        System.out.println(queue.add(6));
        System.out.println(queue.poll());
        System.out.println(queue.add(7));
        System.out.println(queue.add(8));
        System.out.println(queue.add(9));
    }
}
