package com.gitee.fsmxm.thinking.in.algorithm;

/**
 * 双（向）链表节点 有prev和next指向
 */
public class DNode<T> {
    public T val;
    public DNode<T> prev;
    public DNode<T> next;

    public DNode(T val) {
        this.val = val;
    }
}
