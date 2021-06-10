package com.mingh.learn.collections;

import lombok.Builder;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
 */
@Slf4j
public class SetExample {

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/11 0:39
     * @Description:  观察 TreeSet  的排序和去重
     *                          1. 如果要实现对象的排序, 需要实现 Comparable 接口
     *                          2. 如果要实现对象的去重, 对象所有属性都需参与比对
     */
    public void duplicateAndSort() {
        Set<Person> treeSet = new TreeSet<>();
        treeSet.add(Person.builder().name("zhangsan").age(50).build());
        treeSet.add(Person.builder().name("lisi").age(50).build());
        treeSet.add(Person.builder().name("wangwu").age(30).build());
        treeSet.add(Person.builder().name("wangwu").age(30).build());
        log.info("Observe TreeSet duplicate and sort, result is {}", treeSet);
    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/11 0:30
     * @Description:  看下 HashSet 保存的元素信息, 有序(默认升序), 不允许重复
     */
    public void exportTreeSet() {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("hello");
        treeSet.add("world");
        treeSet.add("school");
        treeSet.add("home");
        treeSet.add("home");
        log.info("TreeSet result {}", treeSet);
    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/11 0:24
     * @Description:  看下 HashSet 保存的元素信息, 散列, 不允许重复
     */
    public void exportHashSet() {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("hello");
        hashSet.add("world");
        hashSet.add("school");
        hashSet.add("home");
        hashSet.add("home");
        log.info("HashSet result {}", hashSet);
    }

    @Builder
    @ToString
    static class Person implements Comparable<Person>{
        private String name;
        private Integer age;

        @Override
        public int compareTo(Person o) {
            if (this.age > o.age) {
                return 1;
            } else if (this.age < o.age) {
                return -1;
            } else {
                return this.name.compareTo(o.name);
            }
        }
    }
}
