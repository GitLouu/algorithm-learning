package com.gitee.fsmxm.thinking.in.algorithm;

/**
 * 单链表  只有一个next指向
 * @param <T>
 */
public class SNode<T> {
    public T val;
    public SNode<T> next;
    public SNode(T val) {
        this.val = val;
    }
}
