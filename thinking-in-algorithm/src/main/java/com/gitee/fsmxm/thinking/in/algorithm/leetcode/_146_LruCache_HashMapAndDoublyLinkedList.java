package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 * https://leetcode-cn.com/problems/lru-cache-lcci/
 * 难度 中等
 */
public class _146_LruCache_HashMapAndDoublyLinkedList {

    /**
     * 实现思路：
     * 使用双向链表和哈希表来实现
     * 双向链表维护最近的缓存，哈希表用来查找
     * T(n)=O(n)
     */
    static class LRUCache {

        static class Node {
            int key;
            int val;
            Node prev;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private final Map<Integer, Node> map;
        private final int capacity;
        private final Node head;
        private final Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            // dummy
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            removeNode(node);
            addFirstNode(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            // 如果节点已存在
            if (map.containsKey(key)) {
                // 移除node节点
                removeNode(map.get(key));
            }
            addFirstNode(node);
            map.put(key, node);
            // 如果缓存已满，则移除尾节点
            if (map.size() > capacity) {
                map.remove(removeLastNode().key);
            }
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void addFirstNode(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        Node removeLastNode() {
            Node node = tail.prev;
            node.prev.next = tail;
            tail.prev = node.prev;
            return node;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        assert cache.get(1) == 1;       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        assert cache.get(2) == -1;       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        assert cache.get(1) == -1;       // 返回 -1 (未找到)
        assert cache.get(3) == 3;       // 返回  3
        assert cache.get(4) == 4;       // 返回  4


        cache = new LRUCache(1 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        assert cache.get(1) == -1;       // 返回  -1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        assert cache.get(2) == -1;       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        assert cache.get(1) == -1;       // 返回 -1 (未找到)
        assert cache.get(3) == -1;       // 返回  -1
        assert cache.get(4) == 4;       // 返回  4
    }

}
