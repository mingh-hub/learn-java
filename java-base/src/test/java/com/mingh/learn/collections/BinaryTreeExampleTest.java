package com.mingh.learn.collections;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @BeforeEach
    public void setUp() {
        personMap = Maps.newHashMap();
        personMap.put(ZHANG_SAN, Person.builder().name("张三").age(22).build());
        personMap.put(LI_SI, Person.builder().name("李四").age(28).build());
        personMap.put(WANG_WU, Person.builder().name("王五").age(12).build());
    }

    @Test
    @DisplayName("获取")
    public void testGet() {
        BinaryTreeExample.MiddleBinaryTree<Person> middleBinaryTree1 = new BinaryTreeExample.MiddleBinaryTree<>();
        middleBinaryTree1.add(personMap.get(ZHANG_SAN));
        middleBinaryTree1.add(personMap.get(WANG_WU));
        middleBinaryTree1.add(personMap.get(LI_SI));
        System.out.println(JSON.toJSONString(middleBinaryTree1.get()));
        assertEquals(3, middleBinaryTree1.getCount());
    }

    @Test
    @DisplayName("增加")
    public void testAdd() {
        BinaryTreeExample.MiddleBinaryTree<Person> middleBinaryTree1 = new BinaryTreeExample.MiddleBinaryTree<>();
        middleBinaryTree1.add(personMap.get(ZHANG_SAN));
        middleBinaryTree1.add(personMap.get(WANG_WU));
        middleBinaryTree1.add(personMap.get(LI_SI));
        System.out.println(JSON.toJSONString(middleBinaryTree1));
        BinaryTreeExample.MiddleBinaryTree<Person> middleBinaryTree2 = new BinaryTreeExample.MiddleBinaryTree<>();
        middleBinaryTree2.add(personMap.get(LI_SI));
        middleBinaryTree2.add(personMap.get(ZHANG_SAN));
        middleBinaryTree2.add(personMap.get(WANG_WU));
        System.out.println(JSON.toJSONString(middleBinaryTree2));

        assertEquals(3, middleBinaryTree1.getCount());
        assertEquals(Person.builder().name("张三").age(22).build(), middleBinaryTree1.getRoot().getData());
        assertEquals(Person.builder().name("王五").age(12).build(), middleBinaryTree1.getRoot().getLeft().getData());
        assertEquals(Person.builder().name("李四").age(28).build(), middleBinaryTree1.getRoot().getRight().getData());
        assertEquals(3, middleBinaryTree2.getCount());
        assertEquals(Person.builder().name("李四").age(28).build(), middleBinaryTree2.getRoot().getData());
        assertEquals(Person.builder().name("张三").age(22).build(), middleBinaryTree2.getRoot().getLeft().getData());
        assertEquals(Person.builder().name("王五").age(12).build(), middleBinaryTree2.getRoot().getLeft().getLeft().getData());
    }
}
