package com.gitee.fsmxm.thinking.in.algorithm.stack;

/**
 * stack接口
 * @param <T>
 */
public interface IStack<T> {

    /**
     * 添加数据
     * @param val val
     * @return true -添加成功， false -添加失败
     */
    boolean add(T val);

    /**
     * 弹出数据
     * @return null则没有数据
     */
    T pop();

}
