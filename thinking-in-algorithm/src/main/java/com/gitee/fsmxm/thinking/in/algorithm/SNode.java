package com.gitee.fsmxm.thinking.in.algorithm;

/**
 * 单链表  只有一个next指向
 * @param <T>
 */
public class SNode<T> {
    public T data;
    public SNode<T> next;
    public SNode(T data) {
        this.data = data;
    }
}
