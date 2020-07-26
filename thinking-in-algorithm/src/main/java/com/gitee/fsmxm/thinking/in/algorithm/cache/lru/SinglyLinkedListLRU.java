package com.gitee.fsmxm.thinking.in.algorithm.cache.lru;

import com.gitee.fsmxm.thinking.in.algorithm.SNode;

/**
 * LRU: Least Recently Used  最少最近使用 淘汰策略
 *   即 淘汰最近最少使用的数据
 * 最简单实现思路：(只考虑淘汰策略，不考虑缓存查询，不考虑并发问题）
 *   a. 使用单链表
 *   b. 容量固定
 *   c. 数据靠近头节点表示最近使用过，数据靠近尾节点表示最早使用过
 *   1.   插入数据，判断数据是否已缓存过，是则将数据从原位置删除，并插入到链表头部
 *   2.1  未使用过，判断缓存是否已满，未满，将数据插入链表头部
 *   2.2  缓存已满，将尾节点删除，将数据插入链表头部
 *   时间复杂度是 O(n) 空间复杂度是 O(1)
 */
public class SinglyLinkedListLRU<T> {

    private final int capacity;
    private int size;
    private SNode<T> head;

    public SinglyLinkedListLRU(int capacity) {
        this.capacity = capacity;
    }

    public void add(T data) {
        // 初始数据插入
        if (head == null) {
            head = new SNode<T>(data);
            size++;
        } else {
            // 如果头节点和data相同，则返回
            if (head.data.equals(data)) {
                return;
            }
            // 判断数据是否已经缓存，已经缓存则删除原位置数据，并将其插入头部
            SNode<T> cur = head;
            SNode<T> target;
            while (cur.next != null) {
                if (cur.next.data.equals(data)) {
                    target = cur.next;
                    cur.next = cur.next.next;
                    target.next = head;
                    head = target;
                    return;
                }
                cur = cur.next;
            }
            // 如果没有缓存过，则判断是否容量已满，已满则删除尾节点并将数据插入头部；未满则将数据插入头部
            SNode<T> newNode = new SNode<T>(data);
            newNode.next = head;
            if (size < capacity) {
                head = newNode;
                size++;
            } else {
                cur = head;
                while (cur.next != null) {
                    if (cur.next.next == null) {
                        cur.next = null;
                        break;
                    }
                    cur = cur.next;
                }
                head = newNode;
            }
        }
    }

    public String toString() {
        if (head == null) {
            return null;
        }
        SNode<T> p = head;
        StringBuilder builder = new StringBuilder().append(size).append(": ").append(p.data.toString()).append(", ");
        while (p.next != null) {
            builder.append(p.next.data.toString()).append(", ");
            p = p.next;
        }
        return builder.deleteCharAt(builder.length() - 2).toString();
    }

    static <T> void add(SinglyLinkedListLRU<T> lru, T data) {
        lru.add(data);
        System.out.println("add " + data + ", " + lru.toString());
    }

    public static void main(String[] args) {
        SinglyLinkedListLRU<Integer> lru = new SinglyLinkedListLRU<Integer>(5);
        add(lru, 1);
        add(lru, 2);
        add(lru, 3);
        add(lru, 2);
        add(lru, 4);
        add(lru, 5);
        add(lru, 5);
        add(lru, 5);
        add(lru, 6);
        add(lru, 2);
        add(lru, 2);
        add(lru, 5);
        add(lru, 1);
    }
}
