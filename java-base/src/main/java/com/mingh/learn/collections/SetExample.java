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
 *                        2. HashSet 与 TreeSet
 *                          2.1 TreeSet 保存自定义对象时, 自定义对象需要实现 Comparable 接口, 否则会报 cannot be cast to java.lang.Comparable,
 *                              比较麻烦, 因此大部分情况都会使用 HashSet
 *                        3. 问题
 *                          3.1 为什么 Set 集合可以实现去重?
 *                          观察:
 *                              a. 观察其实现类 HashSet
 *                                  HashSet 内的 add(E e) 方法的实现依赖 HashMap 的 put(K key, V value) 方法, 会将被添加的元素 e 作为 key,
 *                                  一个 Object 对象作为 value 传入 put(e, PRESENT) 方法, HashMap 内会根据 key 计算出 hash 值 hashVal, 把计算出的 hashVal 和 key
 *                                  当做条件去 map 内循环查找是否已经存在对应的 key 了, 若存在则进行替换, 替换的结果相当于去重了!
 *                              b. 观察其实现类 TreeSet
 *                                  TreeSet 内的 add(E e) 方法是调用 NavigableMap(NavigableMap extends SortedMap extends Map) 的 V put(K key, V value) 方法, 而
 *                                  NavigableMap 内的 put(K key, V value) 方法内部又是调用 TreeMap 内的 put(K key, V value) 方法, 在 TreeMap put() 方法内部会循环比较
 *                                  add(E e) 方法传入的 e, 如果有相同的 e, 则通过调用 setValue() 更新 e 所对应的 value, 而不会插入新的节点, 以此来达到去重的效果!
 *                          结论:
 *                              1. 所以如果 HashSet 想要实现在 Set 集合内去重的话, 需要重写 hashCode() 和 equals() 方法
 *                              2. 所以如果 TreeSet 想要实现在 Set 集合内去重的话, 需要实现 Comparable 接口
 *                          3.2 为什么利用 TreeSet 保存的对象需要实现 Comparable 接口?
 *                          观察:
 *                              TreeSet 内的 add(E e) 方法是调用 NavigableMap(NavigableMap extends SortedMap extends Map) 的 V put(K key, V value) 方法,
 *                              其内部会调用 compare() 方法, compare() 方法会将添加的元素 e 强制转换为 Comparable 类型, 如果添加的元素没有实现 Comparable
 *                              接口, e cannot be cast to java.lang.Comparable 的异常
 *                          结论:
 *                              1. 若想通过 TreeSet 实例化 Set 接口, 对于自定义对象, 必须得实现 Comparable 接口, 实现了 Comparable 接口就能到达去重和排序的目的
 *                              2. 基于第一点的结论, 我们通常是通过 HashSet 实例化 Set 接口
 *
 *
 */
@Slf4j
public class SetExample {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/12 14:25
     * @Description 观察 HashSet 的去重
     **/
    public void duplicateAndSortHashSet() {
        Set<Person> treeSet = new HashSet<>();
        treeSet.add(Person.builder().name("zhangsan").age(50).build());
        treeSet.add(Person.builder().name("lisi").age(50).build());
        treeSet.add(Person.builder().name("wangwu").age(30).build());
        treeSet.add(Person.builder().name("wangwu").age(30).build());
        log.info("Observe TreeSet duplicate and sort, result is {}", treeSet);
    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/11 0:39
     * @Description:  观察 TreeSet 的排序和去重
     *                          1. 如果要实现对象的排序, 需要实现 Comparable 接口
     *                          2. 如果要实现对象的去重, 按需求使用对象属性进行对比
     */
    public void duplicateAndSortTreeSet() {
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
     * @Description:  观察 HashSet 保存的元素信息, 有序(默认升序), 不允许重复
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
     * @Description:  观察 HashSet 保存的元素信息, 散列, 不允许重复
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
//    @EqualsAndHashCode
    static class Person implements Comparable<Person> {
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
