package com.mingh.learn.collections;

import com.mingh.learn.beans.BaseBean;
import lombok.Builder;
import lombok.Getter;

/**
 * @ClassName BinaryTreeExample
 * @Author Hai.Ming
 * @Date 2021/6/16 20:40
 * @Description
 *                      树
 *                          树的基本术语
 *                              双亲: 若一个结点有子树, 那么该结点称为子树根的双亲
 *                              孩子: 子树的根称为该结点的孩子
 *                              兄弟: 有相同双亲的结点互为兄弟
 *                              后裔: 一个结点的所有子树上的任何结点都是该结点的后裔
 *                              祖先: 从根结点到某个结点的路径上的所有结点都是该结点的祖先
 *                              结点的度: 结点拥有的子树的数目(二叉树可能有 0, 1, 2)
 *                              叶子结点: 度为 0 的结点
 *                              分支结点: 度不为 0 的结点
 *                              树的度: 树中结点的最大的度
 *                              层次: 根结点的层次为 1, 其余结点的层次等于该结点的双亲结点的层次加 1
 *                              树的高度: 树中结点的最大层次
 *                              森林: 0 个或多个不相交的树组成。对森林加一个根, 即成树; 对树删除根, 即森林
 *
 *                      二叉树
 *                          1. 二叉树是树的一种特殊形态。二叉树的特点是每个结点最多拥有两个子结点, 分别称为左子树和右子树。
 *                              树: 树是一种数据结构, 它是由 n(n>=1) 个有限结点组成的一个具有层次关系的集合
 *                          2. 特殊的二叉树
 *                              2.1 斜树: 所有结点都只有左子树的叫做左斜树; 所有结点都只有右子树的叫做右斜树
 *                              2.2 满二叉树: 每一层结点都达到了最大个数。即: 如果满二叉树的深度为 k, 那么其结点总个数为 2^k-1 个, 每一层的结点个数为: 2^(层数-1)
 *                              2.3 完全二叉树: 深度为 k 的二叉树, 从第一层到第 k-1 层各层结点都是满的, 仅最下面第 k 层是满的(满二叉树), 或从右向左连续缺若干结点
 *                          3. 二叉树的性质
 *                              3.1 在非空二叉树的第 n 层上，至多有 2^(n-1) 个结点(满二叉树)
 *                              3.2 深度为 k 的二叉树至多有 2^k-1 个结点(满二叉树)
 *                              3.3 假设二叉树中度(结点分叉数)为 0 的结点个数为 n0, 度为 1 的结点个数为 n1, 度为 2 (最多)的结点个数为 n2, 则结点总数为: n = n0 + n1 + n2
 *                          4. 二叉树的存储方式
 *                              顺序存储
 */
public class BinaryTreeExample {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/17 20:24
     * @Description 二叉树算法-前序(root-left-right)
     **/
    public static class PreBinaryTree<T extends Comparable<T>>{
        /**
         * 结点个数
         */
        private int count;

        private Node<T> root;

    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/17 0:17
     * @Description:
     */
    public static class MiddleBinaryTree{

    }
}

/**
 * @Author Hai.Ming
 * @Date 2021/6/16 20:41
 * @Description 结点
 **/
@Getter
@Builder
class Node<T extends Comparable<T>> {

    /**
     * 结点存储对象
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
