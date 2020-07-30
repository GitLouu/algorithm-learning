package com.gitee.fsmxm.thinking.in.algorithm.queue;

/**
 * 循环队列  （数组实现）
 * 用于避免数组实现的队列 存在数据迁移的情况
 * @param <T>
 */
public class CircularQueue<T> implements IQueue<T> {

    private final int capacity;
    private final T[] data;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
    }

    public boolean add(T val) {
        // 判断是否已满(队尾的位置是不存数据的)
        if ((tail + 1) % data.length == head) {
            return false;
        }
//        if (tail == data.length) {
//            tail = 0;
//        }
//        data[tail++] = val;
        // 每次前进1个并保证到终点回到启点，这3行可以用如下方法代替
        data[tail] = val;
        tail = (tail + 1) % data.length; // 在循环的方格内前进1
        return true;
    }

    public T poll() {
        if (head == tail) {
            return null;
        }
//        if (head == data.length) {
//            head = 0;
//        }
//        return data[head++];
        T val = data[head];
        head = (head + 1) % data.length;
        return val;
    }

    public static void main(String[] args) {
        IQueue<Integer> queue = new CircularQueue<Integer>(4);
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
