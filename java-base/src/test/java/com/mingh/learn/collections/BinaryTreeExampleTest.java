package com.mingh.learn.collections;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @ClassName BinaryTreeExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/18 0:13
 * @Version 1.0
 * @Description 二叉树算法实现
 */
@DisplayName("二叉树算法实现")
public class BinaryTreeExampleTest {

    private Map<String, Person> personMap;

    private static final String ZHANG_SAN = "zhangsan";
    private static final String LI_SI = "lisi";
    private static final String WANG_WU = "wangwu";
    private static final String LIU_LIU = "LIULIU";

    @BeforeEach
    public void setUp() {
        personMap = Maps.newHashMap();
        personMap.put(ZHANG_SAN, Person.builder().name("张三").age(22).build());
        personMap.put(LI_SI, Person.builder().name("李四").age(28).build());
        personMap.put(WANG_WU, Person.builder().name("王五").age(12).build());
        personMap.put(LIU_LIU, Person.builder().name("刘六").age(26).build());
    }

    @Test
    @DisplayName("从二叉树中删除指定结点")
    public void testRemove() throws Exception {
        System.err.println("============================原始数据============================");
        System.out.println(JSON.toJSONString("原始数据" + getTree()));
        Thread.sleep(100);
        // 删除叶子结点
        System.err.println("============================删除叶子结点============================");
        BinaryTreeExample<Person> tree1 = getTree();
        tree1.remove(Person.builder().name("J").age(32).build());
        System.out.println("删除叶子结点后的数据为: " + JSON.toJSONString(tree1));
        assertEquals(tree1.getRoot().getRight().getLeft().getData(), Person.builder().name("F").age(33).build());
        assertNull(tree1.getRoot().getRight().getLeft().getRight());
        Thread.sleep(100);
        // 删除只有左子树的结点
        System.err.println("============================删除只有左子树的结点============================");
        BinaryTreeExample<Person> tree2 = getTree();
        tree2.remove(Person.builder().name("F").age(33).build());
        System.out.println("删除只有左子树的结点后数据为: " + JSON.toJSONString(tree2));
        assertEquals(Person.builder().name("J").age(32).build(), tree2.getRoot().getRight().getLeft().getData());
        Thread.sleep(100);
        // 删除只有右子树的结点
        System.err.println("============================删除只有右子树的结点============================");
        BinaryTreeExample<Person> tree3 = getTree();
        tree3.remove(Person.builder().name("G").age(46).build());
        System.out.println("删除只有右子树的结点后数据为: " + JSON.toJSONString(tree3));
        assertEquals(Person.builder().name("K").age(58).build(), tree3.getRoot().getRight().getRight().getData());
        assertNull(tree3.getRoot().getRight().getRight().getRight());
        Thread.sleep(100);
        // 删除既有左子树又有右子树的结点
        System.err.println("=========================删除既有左子树又有右子树的结点=========================");
        BinaryTreeExample<Person> tree4 = getTree();
        tree4.remove(Person.builder().name("B").age(25).build());
        System.out.println("删除既有左子树又有右子树的结点后数据为: " + JSON.toJSONString(tree4));
        assertEquals(Person.builder().name("E").age(28).build(), tree4.getRoot().getLeft().getData());
        assertEquals(Person.builder().name("D").age(20).build(), tree4.getRoot().getLeft().getLeft().getData());
    }

    @Test
    @DisplayName("二叉树转数组")
    public void testToArray() {
        BinaryTreeExample<Person> middleBinaryTree = new BinaryTreeExample<>();
        middleBinaryTree.add(personMap.get(ZHANG_SAN));
        middleBinaryTree.add(personMap.get(WANG_WU));
        middleBinaryTree.add(personMap.get(LI_SI));
        middleBinaryTree.add(personMap.get(LI_SI));
        Person[] p = new Person[middleBinaryTree.getCount()];
        Person[] people = middleBinaryTree.toArray(p);
        Person[] people2 = middleBinaryTree.toArray(p);
        System.out.println(JSON.toJSONString(people));
        assertEquals(3, middleBinaryTree.getCount());
        assertEquals(people[0], Person.builder().name("王五").age(12).build());
        assertEquals(people[1], Person.builder().name("张三").age(22).build());
        assertEquals(people[2], Person.builder().name("李四").age(28).build());
    }

    @Test
    @DisplayName("向二叉树中添加结点, 不允许重复")
    public void testAdd() {
        BinaryTreeExample<Person> middleBinaryTree1 = new BinaryTreeExample<>();
        middleBinaryTree1.add(personMap.get(ZHANG_SAN));
        middleBinaryTree1.add(personMap.get(WANG_WU));
        middleBinaryTree1.add(personMap.get(LI_SI));
        middleBinaryTree1.add(personMap.get(LIU_LIU));
        middleBinaryTree1.add(Person.builder().name("李四").age(28).build());
        System.out.println(middleBinaryTree1);
        System.err.println("========"+middleBinaryTree1.getRoot().getLeft().getParent());
        System.out.println("== result===>" + (middleBinaryTree1.getRoot().getLeft().getParent().getData()==Person.builder().name("张三").age(22).build()));
        System.err.println("========"+middleBinaryTree1.getRoot().getRight().getLeft().getParent());
        BinaryTreeExample<Person> middleBinaryTree2 = new BinaryTreeExample<>();
        middleBinaryTree2.add(personMap.get(LI_SI));
        middleBinaryTree2.add(personMap.get(ZHANG_SAN));
        middleBinaryTree2.add(personMap.get(WANG_WU));
        System.out.println(middleBinaryTree2);

        assertEquals(4, middleBinaryTree1.getCount());
        assertEquals(Person.builder().name("张三").age(22).build(), middleBinaryTree1.getRoot().getData());
        assertEquals(Person.builder().name("王五").age(12).build(), middleBinaryTree1.getRoot().getLeft().getData());
        assertEquals(Person.builder().name("李四").age(28).build(), middleBinaryTree1.getRoot().getRight().getData());
        assertEquals(Person.builder().name("张三").age(22).build(), middleBinaryTree1.getRoot().getLeft().getParent().getData());
        assertEquals(Person.builder().name("李四").age(28).build(), middleBinaryTree1.getRoot().getRight().getLeft().getParent().getData());
        assertEquals(3, middleBinaryTree2.getCount());
        assertEquals(Person.builder().name("李四").age(28).build(), middleBinaryTree2.getRoot().getData());
        assertEquals(Person.builder().name("张三").age(22).build(), middleBinaryTree2.getRoot().getLeft().getData());
        assertEquals(Person.builder().name("王五").age(12).build(), middleBinaryTree2.getRoot().getLeft().getLeft().getData());
    }

    private BinaryTreeExample<Person> getTree() {
        BinaryTreeExample<Person> tree = new BinaryTreeExample<>();
        tree.add(Person.builder().name("A").age(30).build());
        tree.add(Person.builder().name("B").age(25).build());
        tree.add(Person.builder().name("C").age(38).build());
        tree.add(Person.builder().name("D").age(20).build());
        tree.add(Person.builder().name("E").age(28).build());
        tree.add(Person.builder().name("F").age(33).build());
        tree.add(Person.builder().name("G").age(46).build());
        tree.add(Person.builder().name("H").age(15).build());
        tree.add(Person.builder().name("I").age(22).build());
        tree.add(Person.builder().name("J").age(32).build());
        tree.add(Person.builder().name("K").age(58).build());
        return tree;
    }
}
