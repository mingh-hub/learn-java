package com.mingh.learn.collections;

import com.mingh.learn.beans.BaseBean;
import lombok.Builder;
import lombok.Getter;

/**
 * @ClassName BinaryTreeExample
 * @Author Hai.Ming
 * @Date 2021/6/16 20:40
 * @Description 二叉树
 *                      1. 二叉树是树的一种特殊形态。二叉树的特点是每个节点最多拥有两个子节点, 分别称为左子树和右子树。
 *                      2. 特殊的二叉树
 *                          2.1 斜树: 所有节点都只有左子树的叫做左斜树; 所有节点都只有右子树的叫做右斜树
 *                          2.2 满二叉树: 每一层节点都达到了最大个数。即: 如果满二叉树的深度为 k, 那么其节点总个数为 2^k-1 个, 每一层的节点个数为: 2^(层数-1)
 *                          2.3 完全二叉树: 深度为 k 的二叉树, 从第一层到第 k-1 层各层节点都是满的, 仅最下面第 k 层是满的(满二叉树), 或从右向左连续缺若干结点
 *                      3. 二叉树的性质
 *                        3.1 在非空二叉树的第 n 层上，至多有 2^(n-1) 个结点(满二叉树)
 *                        3.2 深度为 k 的二叉树至多有 2^k-1 个结点(满二叉树)
 *                        3.3 假设二叉树中度(节点分叉数)为 0 的节点个数为 n0, 度为 1 的节点个数为 n1, 度为 2 (最多)的节点个数为 n2, 则节点总数为: n = n0 + n1 + n2
 *                      3. 二叉树的存储方式
 *                          顺序存储
 */
public class BinaryTreeExample {


    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/17 0:17
     * @Description:  中序
     */
    public static class MiddleBinaryTree{

    }
}

/**
 * @Author Hai.Ming
 * @Date 2021/6/16 20:41
 * @Description 节点
 **/
@Getter
@Builder
class Node<T extends Comparable<T>> {
    /**
     * 节点存储对象
     */
    T data;
    /**
     * 左子树
     */
    Node<T> left;
    /**
     * 右子树
     */
    Node<T> right;
}

/**
 * @Author Hai.Ming
 * @Date 2021/6/16 21:02
 * @Description 测试数据, 自定义对象, 用于测试二叉树的方法
 **/
@Getter
@Builder
class Person extends BaseBean implements Comparable<Person> {
    private static final long serialVersionUID = -6613632338547202221L;

    private String name;

    private int age;

    @Override
    public int compareTo(Person o) {
        if (this.age > o.getAge()) {
            return 1;
        } else if (this.age < o.getAge()) {
            return -1;
        } else {
            return this.name.compareTo(o.getName());
        }
    }
}
