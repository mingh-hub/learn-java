package com.mingh.learn.collections;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.List;

/**
 * @ClassName IteratorExample
 * @Author Hai.Ming
 * @Date 2021/6/10 1:07
 * @Version 1.0
 * @Description java.util.Iterator ★★★★★
 */
@Slf4j
public class IteratorExample {

    private static final List<String> list = Lists.newArrayList();

    /**
     * @Author Hai.Ming
     * @Date 2021/6/12 19:24
     * @Description 从集合中移除元素
     *                      1. 在迭代输出集合中的数据时, 不要使用集合中的 remove() 方法, 而只能使用 Iterator 中的方法
     *                      2. 问题:
     *                          2.1 为什么在集合输出时, 只能使用 Iterator 中的方法?
     *                          观察: ArrayList 内部的 next() 方法实现
     *                              java.lang.Iterable 接口中有个 iterator() 方法, ArrayList 在覆写该方法时会返回一个内部类 Itr, Itr 内部
     *                              有个游标指向下个要返回的元素, 在调用 remove() 方法之前, modCount=4(list 初始化增加了四个元素,
     *                              被修改了四次), expectedModCount=modCount=4, 当调用 ArrayList 的 remove() 方法时, modCount++,
     *                              但 expectedModCount 没被修改, 在每一次调用 next() 方法时, 首先都会检查 modCount 和 expectedModCount
     *                              是否相等, 不等的话就会抛出 java.util.ConcurrentModificationException
     *                          观察: Iterator 迭代器的 remove() 方法
     *                              迭代器内的 remove() 方法, 除了对游标进行了修改, 每次还对 expectedModCount 进行了修正, 因而删除后不会报错
     *                          总结:
     *                              1. 编译器在遇到增强型 for 循环时会自动将其编译成迭代器循环遍历, 会报同样的错误
     *                              2. 一般 for 循环在删除最后一个元素时, 会报 java.lang.IndexOutOfBoundsException
     *                              3. 总之循环迭代输出时如果要删除元素, 需使用 Iterator 中的 remove() 方法
     *
     *
     **/
    public void remove() {
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            if (StringUtils.equals("hello", str)) {
//                list.remove("hello");  // 调用集合中的 remove() 方法会发报错, java.util.ConcurrentModificationException
                iter.remove();
            } else {
                log.info("output element [{}]", str);
            }
        }
//        for (int i = 0; i < list.size(); i++) {
//            if (StringUtils.equals("you", list.get(i))) {
//                list.remove(list.get(i));
//            }
//            log.info("output element [{}]", list.get(i));
//        }
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/12 19:10
     * @Description 通过 Iterator 进行循环输出
     **/
    public void loop() {
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            log.info("loop output result with iterator, element is [{}]", iter.next());
        }
    }

    static {
        list.add("hello");
        list.add("world");
        list.add("thank");
        list.add("you");
    }
}
