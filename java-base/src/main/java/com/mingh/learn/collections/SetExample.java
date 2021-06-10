package com.mingh.learn.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName SetExample
 * @Author Hai.Ming
 * @Date 2021/6/11 0:09
 * @Version 1.0
 * @Description java.util.Set ★★★★★
 *                        1. Set 集合特点:
 *                          1.1 保存的元素是不可重复的, List 去重可利用 Set 集合
 *                          1.2 Set 接口并没有像 List 接口那样进行扩充, 而是完整的按照 Collection 接口的标准实现了继承, 没有 get(), set() 方法
 *                          1.3 子类 HashSet 无序且元素不可重复, TreeSet 有序且元素不可重复
 *                        2. Set 集合
 */
@Slf4j
public class SetExample {

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/11 0:24
     * @Description:  看下 HashSet 保存的元素信息
     */
    public void exportHashSet() {
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("school");
        set.add("home");
        set.add("home");
        log.info("HashSet result {}", set);
    }
}
