package com.mingh.learn.collections;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @ClassName BinaryTreeExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/18 0:13
 * @Version 1.0
 * @Description 二叉树算法实现
 */
@DisplayName("二叉树算法实现")
public class BinaryTreeExampleTest {

    @Test
    @DisplayName("增加")
    public void testAdd() {
        BinaryTreeExample.MiddleBinaryTree<Person> middleBinaryTree = new BinaryTreeExample.MiddleBinaryTree<>();
        middleBinaryTree.add(Person.builder().name("张三").age(22).build());
        middleBinaryTree.add(Person.builder().name("王五").age(12).build());
        middleBinaryTree.add(Person.builder().name("李四").age(28).build());
        System.out.println(JSON.toJSONString(middleBinaryTree));
    }
}
