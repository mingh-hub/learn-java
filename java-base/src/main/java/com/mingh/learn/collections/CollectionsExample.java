package com.mingh.learn.collections;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName CollectionsExample
 * @Author Hai.Ming
 * @Date 2021/6/13 15:32
 * @Description java.util.Collections ★
 *                      观察下集合工具类中的某些方法
 */
public class CollectionsExample {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 15:40
     * @Description 二分查找
     *                      1. 使用二分查找的时候, List 中的元素需要实现 Comparable 接口
     *                      2. 二分查找前必须根据列表元素的自然顺序对列表进行升序排序(通过 sort(List) 方法) 否则查找结果是不确定的
     *                      2. 如果集合内对象实现了 java.util.RandomAccess 接口或者集合大小在 5000 以内将使用下标进行查找; 否则将使用 ListIterator 进行查找
     *                      3. 查找结果会返回元素所在集合中的下标, 如查找的元素在集合中存在多个将返回 0
     **/
    public void binarySearch() {
        List<String> list = Lists.newArrayList();

        Collections.addAll(list, "a", "b", "c", "d", "e");
        System.out.println(list);
        System.out.println("search c: " + Collections.binarySearch(list, "c"));

        list.removeAll(list);

        Collections.addAll(list, "a", "b", "d", "e", "a", "c");
        System.out.println(list);
        System.out.println("search a: " + Collections.binarySearch(list, "a"));  // 0
        System.out.println("search c: " + Collections.binarySearch(list, "c"));  // -3
        System.out.println("search b: " + Collections.binarySearch(list, "b"));  // 1 正常
        System.out.println("search d: " + Collections.binarySearch(list, "d"));  // 2 正常
        System.out.println("search e: " + Collections.binarySearch(list, "e"));  // -7
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 15:37
     * @Description 集合元素反转
     **/
    public void reverse() {
        List<String> list = Lists.newArrayList();
        Collections.addAll(list, "a", "b", "c", "d", "e");
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 15:33
     * @Description 利用 Collections 向集合中添加元素
     **/
    public void addAll() {
        List<String> list = Lists.newArrayList();
        Collections.addAll(list, "a", "b", "c", "d", "e");
        System.out.println(list);
    }
}
