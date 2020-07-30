package com.gitee.fsmxm.thinking.in.algorithm.queue;

public interface IQueue<T> {
    /**
     * 入队，添加数据
     * @param val val
     * @return true -添加成功， false -失败
     */
    boolean add(T val);

    /**
     * 出队，取出数据
     * @return null - 无数据
     */
    T poll();
}
