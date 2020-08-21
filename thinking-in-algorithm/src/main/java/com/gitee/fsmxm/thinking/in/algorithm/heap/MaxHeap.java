package com.gitee.fsmxm.thinking.in.algorithm.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap<T> {

    private T[] data;
    private int size;
    private final Comparator<T> comparator;

    public MaxHeap() {
        this(0, null);
    }

    public MaxHeap(int initialCapacity, Comparator<T> comparator) {
        if (initialCapacity < 2) {
            initialCapacity = 8;
        }
        data = generate(initialCapacity);
        this.comparator = comparator;
    }

    @SuppressWarnings("unchecked")
    private T[] generate(int len) {
        return (T[]) new Object[len];
    }

    public void add(T t) {
        if (size++ == 0) {
            data[1] = t;
            return;
        }
        if (size >= data.length) {
            ensureCapacity();
        }
        shiftUp(size, t);
    }

    private void shiftUp(int i, T t) {
        if (comparator != null) {
            shiftUpUsingComparator(i, t);
        } else {
            shiftUpComparable(i, t);
        }
    }

    @SuppressWarnings("unchecked")
    private void shiftUpComparable(int i, T t) {
        Comparable<? super T> val = (Comparable<? super T>) t;
        int parent = i / 2;
        while (parent > 0 && val.compareTo(data[parent]) > 0) {
            data[i] = data[parent];
            i = parent;
            parent = i / 2;
        }
        data[i] = t;
    }

    private void shiftUpUsingComparator(int i, T t) {
        while (i / 2 > 0 && comparator.compare(t, data[i / 2]) > 0) {
            data[i] = data[i / 2];
            i = i / 2;
        }
        data[i] = t;
    }

    public T peek() {
        return data[1];
    }

    public T poll() {
        if (data[1] == null) {
            return null;
        }
        T res = data[1];

        T t = data[size];
        data[size--] = null;
        shiftDown(1, t);

        return res;
    }

    public int size() {
        return size;
    }

    private void shiftDown(int i, T t) {
        if (comparator != null) {
            shiftDownUsingComparator(i, t);
        } else {
            shiftDownComparable(i, t);
        }
    }

    @SuppressWarnings("unchecked")
    private void shiftDownComparable(int i, T t) {
        Comparable<? super T> val = (Comparable<? super T>) t;
        while (i < size) {
            int j = i;
            if (2 * i <= size && val.compareTo(data[2 * i]) < 0) {
                j = 2 * i;
            }
            if (2 * i + 1 <= size && ((Comparable<? super T>) data[j]).compareTo(data[2 * i + 1]) < 0) {
                j = 2 * i + 1;
            }
            if (j == i) {
                break;
            }
            data[i] = data[j];
            i = j;
        }
        data[i] = t;
    }

    private void shiftDownUsingComparator(int i, T t) {
        while (i < size) {
            int j = i;
            if (2 * i <= size && comparator.compare(t, data[2 * i]) < 0) {
                j = 2 * i;
            }
            if (2 * i + 1 <= size && comparator.compare(data[j], data[2 * i + 1]) < 0) {
                j = 2 * i + 1;
            }
            if (j == i) {
                break;
            }
            data[i] = data[j];
            i = j;
        }
        data[i] = t;
    }


    private void ensureCapacity() {
        T[] array = generate(data.length * 2);
        System.arraycopy(data, 1, array, 1, data.length - 1);
        data = array;
    }

    public T[] toArray() {
        return Arrays.copyOfRange(data, 1, size + 1);
    }

    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        System.out.println(Arrays.toString(heap.toArray()));
        heap.poll();
        System.out.println(Arrays.toString(heap.toArray()));
        heap.add(0);
        heap.add(4);
        heap.add(5);
        heap.add(8);
        System.out.println(Arrays.toString(heap.toArray()));
        heap.poll();
        System.out.println(Arrays.toString(heap.toArray()));
        heap.poll();
        System.out.println(Arrays.toString(heap.toArray()));
        heap.poll();
        System.out.println(Arrays.toString(heap.toArray()));
        heap.add(1);
        heap.add(1);
        heap.add(1);
        System.out.println(Arrays.toString(heap.toArray()));

        System.out.println("--------");
        PriorityQueue<Integer> queue = new PriorityQueue<>((t1, t2) -> -1 * t1.compareTo(t2));
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(Arrays.toString(queue.toArray()));
        queue.poll();
        System.out.println(Arrays.toString(queue.toArray()));
        queue.add(0);
        queue.add(4);
        queue.add(5);
        queue.add(8);
        System.out.println(Arrays.toString(queue.toArray()));
        queue.poll();
        System.out.println(Arrays.toString(queue.toArray()));
        queue.poll();
        System.out.println(Arrays.toString(queue.toArray()));
        queue.poll();
        System.out.println(Arrays.toString(queue.toArray()));
        queue.add(1);
        queue.add(1);
        queue.add(1);
        System.out.println(Arrays.toString(queue.toArray()));
    }

}
