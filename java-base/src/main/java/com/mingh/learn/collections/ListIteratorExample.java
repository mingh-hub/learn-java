package com.mingh.learn.collections;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.ListIterator;

/**
 * @ClassName ListIteratorExample
 * @Author Hai.Ming
 * @Date 2021/6/13 00:41
 * @Description java.util.ListIterator
 */
public class ListIteratorExample {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 00:44
     * @Description 观察 ListIterator 的双向迭代
     *                      1. ListIterator 的实例化只能通过 List.listIterator() 来进行
     *                      2. 注意的一点是迭代输出时根据指针来的, 只能先由前向后迭代, 再由后向前迭代; 否则先由前向后迭代会没有值输出
     **/
    public void bothWayLoop() {
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        ListIterator<String> iter = list.listIterator();
        // 由前向后迭代
        System.out.print("由前向后迭代: ");
        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
        }
        System.out.println();
        // 由后向前迭代
        System.out.print("由后向前迭代: ");
        while (iter.hasPrevious()) {
            System.out.print(iter.previous() + ", ");
        }
    }
}
