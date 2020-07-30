package com.gitee.fsmxm.thinking.in.algorithm.queue;

/**
 * 数组实现队列 （顺序队列）
 * @param <T>
 */
public class ArrayQueue<T> implements IQueue<T> {

    private final int capacity;
    private final T[] data;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
    }

    public boolean add(T val) {
        if (tail >= capacity) {
            if (head == 0) { // 队列已满
                return false;
            }
            // 迁移数据
            System.arraycopy(data, head, data, 0, tail - head);
            tail = tail - head;
            head = 0;
        }
        data[tail] = val;
        tail++;
        return true;
    }

    public T poll() {
        if (head == tail) {
            return null;
        }
        return data[head++];
    }

    public static void main(String[] args) {
        IQueue<Integer> queue = new ArrayQueue<Integer>(3);
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
