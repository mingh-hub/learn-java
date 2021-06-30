package com.mingh.learn.collections;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @ClassName ListExample
 * @Author Hai.Ming
 * @Date 2021/6/9 20:04
 * @Description java.util.List ★★★★★
 *                      1. 接口, 继承 Collection, JDK 1.2 提供
 *                      2. 自实现链表操作
 *                      3. ArrayList 与 Vector 区别
 *                          3.1 推出时间
 *                              ArrayList JDK1.2, Vector JDK1.0
 *                          3.2 性能
 *                              ArrayList 异步处理, 性能更高; Vector 同步处理, 性能较低
 *                          3.2 安全性
 *                              ArrayList 非线程安全的操作; Vector 线程安全的操作
 *                          3.2 输出
 *                              ArrayList 支持 Iterator, ListIterator, forEach; Vector 支持 Iterator, ListIterator, forEach, +elements() : Enumeration
 *                      3. ArrayList 与 LinkedList 区别
 *                          LinkedList 是一个真正的链表实现类, 其功能要比 ArrayList 丰富(addFirst(), addLast(), push(), pop())
 */
@Slf4j
public class ListExample {

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/10 23:18
     * @Description:  根据索引添加元素
     */
    public void addWithIndex() {
        List<String> list = Lists.newArrayList();
        // FILO
        list.add(0, "hello");
        list.add(0, "world");
        list.add(0, "say");
        list.add(0, "bye");
        list.add(0, "bye");
        list.add(list.size(), "111");  // list.add(list.size() + 1, "111"); 这样会抛异常, java.lang.IndexOutOfBoundsException
        log.info("add list with index, result is {}", list);
    }
}
