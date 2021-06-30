package com.mingh.learn.collections;

import com.mingh.learn.beans.BaseBean;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @ClassName BinaryTreeExample
 * @Author Hai.Ming
 * @Date 2021/6/16 20:40
 * @Description ★★★★★
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
@Getter
@ToString
public class BinaryTreeExample<T extends Comparable<T>> {

    /**
     * 二叉树结点个数
     */
    private int count;
    /**
     * 根结点, 必须要保留住根结点
     */
    private Node root;
    /**
     * 指针
     */
    int foot;

    /**
     * @Author Hai.Ming
     * @Date 2021/6/19 16:07
     * @Description 移除二叉树中的数据-中序
     *                      1. 入参为空不进行任何操作
     *                      2. 二叉树中没有元素也不进行任何操作
     *                      3. 中序查询二叉树中是否包含指定移除的元素
     *                          3.1 包含: 删除该结点及其后裔
     *                              a. 叶子结点
     *                                  |- 度为 0 的结点
     *                              b. 分支结点
     *                                  |- 度为 1 的结点(有左子树或者右子树)
     *                                  |- 度为 2 的结点(左右子树都存在)
     *                          3.2 不包含: 不做处理
     **/
    public void remove(T data) {
        if (data == null || this.count == 0) return;
        else this.root.removeNode(new Node(data));
    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/17 23:48
     * @Description:  保存数据 ASC, 重复结点不做处理
     */
    public void add(T data) {
        final Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
            count++;
        } else {
            this.root.addNode(newNode);
        }
    }

    /**
     * @Author: Hai.Ming
     * @Date: 2021/6/18 0:37
     * @Description: 将二叉树转为数组输出, left -> right (ASC)
     */
    public T[] toArray(T[] dataArray) {
        if (this.count > 0) {
            this.foot = 0;  // 必须重置 foot, 否则重复调用会报异常: java.lang.ArrayIndexOutOfBoundsException
            this.root.toNodeArray(dataArray);
            return dataArray;
        } else {
            return null;
        }
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/16 20:41
     * @Description Node 结点 ★★★★★
     *                        1. 数据结构中必须要有 Node 类, 无论是集合还是数组的操作都离不开 Node 结点
     *                        2. 这个类负责保存数据及结点的关系匹配
     **/
    @Getter
    class Node extends BaseBean{
        private static final long serialVersionUID = 2049264298161879393L;
        /**
         * 结点存储对象
         */
        T data;
        /**
         * 父结点
         */
        Node parent;
        /**
         * 左子树, 比父结点小的对象
         */
        Node left;
        /**
         * 右子树, 比父结点大的对象
         */
        Node right;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        /**
         * @Author Hai.Ming
         * @Date 2021/6/19 16:13
         * @Description 移除指定结点, 指定结点被移除后, 其指定后裔也会被移除
         **/
        public void removeNode(Node node) {
            // 找左子树
            if (this.data.compareTo(node.data) > 0) {
                this.left.removeNode(node);
            }
            if (this.data.compareTo(node.data) == 0) {
                // 叶子结点
                if (this.left == null && this.right == null) {
                    if (this.data.compareTo(this.parent.left.data) == 0) {
                        this.parent.left = null;
                    } else {
                        this.parent.right = null;
                    }
                }
                // 分支结点(有左子树)
                if (this.left != null && this.right == null) {
                    if (this.data.compareTo(this.parent.left.data) == 0) {  // 删除结点为父结点左子树
                        this.parent.left = this.left;
                    } else {  // 删除结点为父结点右子树
                        this.parent.right = this.left;
                    }
                    this.left.parent = this.parent;  // 重置父结点
                }
                // 分支结点(有右子树)
                if (this.left == null && this.right != null) {
                    if (this.data.compareTo(this.parent.left.data) == 0) {  // 删除结点为父结点左子树
                        this.parent.left = this.right;
                    } else {  // 删除结点为父结点右子树
                        this.parent.right = this.right;
                    }
                    this.right.parent = this.parent;  // 重置父结点
                }
                // 分支结点(既有左子树又有右子树)
                if (this.left != null && this.right != null) {
                    if (this.data.compareTo(this.parent.left.data) == 0) {  // 删除结点为父结点左子树
                        // 右子树替换原结点
                        this.parent.left = this.right;
                    } else {  // 删除结点为父结点右子树
                        // 右子树替换原结点
                        this.parent.right = this.right;
                    }
                    // 右结点父结点替换
                    this.right.parent = this.parent;
                    // 找出要删除结点右子树的最小结点
                    Node minNode = searchMinNode(this.right);
                    minNode.left = this.left;
                    this.left.parent = minNode;
                }
            }
            // 找右子树
            if (this.data.compareTo(node.data) < 0) {
                this.right.removeNode(node);
            }
        }

        /**
         * @Author Hai.Ming
         * @Date 2021/6/20 14:37
         * @Description 找出指定结点的最小结点
         **/
        public Node searchMinNode(Node node) {
            if (node == null || node.left == null) {
                return node;
            }
            return searchMinNode(node.left);
        }

        /**
         * @Author Hai.Ming
         * @Date 2021/6/18 14:18
         * @Description 将二叉树中的各个结点以数组的方式输出, 按默认升序排列, left -> right (ASC)
         *                      1. 中序输出, left -> root -> right
         *                      2. 判断左子树, 不为空则交给左子树完成
         *                      3. 将当前 root 结点中保存的对象放入数组
         *                      4. 判断右子树, 不为空则交给右子树完成
         **/
        public void toNodeArray(T[] result) {
            if (this.left != null) {
                this.left.toNodeArray(result);
            }
            result[foot++] = this.data;
            if (this.right != null) {
                this.right.toNodeArray(result);
            }
        }

        /**
         * @Author: Hai.Ming
         * @Date: 2021/6/18 0:05
         * @Description: left -> right (ASC), 重复结点不做处理
         */
        public void addNode(Node newNode) {
            if (this.data.compareTo(newNode.getData()) > 0) {
                if (this.left == null) {
                    this.left = newNode;
                    this.left.parent = this;
                    count++;
                } else {
                    this.left.addNode(newNode);
                }
            } else if (this.data.compareTo(newNode.getData()) < 0) {
                if (this.right == null) {
                    this.right = newNode;
                    this.right.parent = this;
                    count++;
                } else {
                    this.right.addNode(newNode);
                }
            }
        }
    }
}

/**
 * @Author Hai.Ming
 * @Date 2021/6/16 21:02
 * @Description 测试数据, 自定义对象, 用于测试二叉树的方法
 **/
@Getter
@Builder
@EqualsAndHashCode
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
