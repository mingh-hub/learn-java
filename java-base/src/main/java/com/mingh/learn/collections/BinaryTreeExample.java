package com.mingh.learn.collections;

import com.mingh.learn.beans.BaseBean;
import lombok.Builder;
import lombok.Getter;

/**
 * @ClassName BinaryTreeExample
 * @Author Hai.Ming
 * @Date 2021/6/16 20:40
 * @Description 二叉树
 */
public class BinaryTreeExample {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/16 20:41
     * @Description 节点
     **/
    static class Node<T extends Comparable<T>>{
        /**
         * 节点存储对象
         */
        T data;
        /**
         * 左子树
         */
        Node<T> leftNode;
        /**
         * 右子树
         */
        Node<T> rightNode;
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/16 21:02
     * @Description 测试数据, 自定义对象, 用于测试二叉树的方法
     **/
    @Getter
    @Builder
    static class Person extends BaseBean {
        private String name;
        private int age;
    }
}
