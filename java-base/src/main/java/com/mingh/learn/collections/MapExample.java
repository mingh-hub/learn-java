package com.mingh.learn.collections;

import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

/**
 * @ClassName MapExample
 * @Author Hai.Ming
 * @Date 2021/6/9 20:03
 * @Description java.util.Map JDK 1.2
 *                      Map 保存的是二元偶对象(官方说法), 其实就是键值对
 *                      问题: Hashtable 和 HashMap 区别?
 *                          1. Hashtable 出自 JDK 1.0, 自 1.2 的时候改为实现 Map 集合; HashMap 和 Map 一样都是出自 JDK 1.2
 *                          2. Hashtable 是线程安全的, 同步处理, 性能较低; HashMap 是非线程安全的, 异步处理, 性能更高
 *                          3. Hashtable 不允许 key 或 value 为 null, 否则报 NPE; HashMap 则没有要求
 *                      结论:
 *                          开发之中不可能回避 null 的问题, 所以会更多的使用 HashMap
 */
public class MapExample {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 14:59
     * @Description 测试利用自定义的类当做 Map 的 key, 此时自定义的类必须要重写 hashCode() 和 equals()
     *                      问题: 为什么要重写 hashCode() 和 equals() 才能实现根据自定义对象找到对应的值
     *                      观察: HashMap 中的 get(Object key)
     *                              HashMap 中的 get(Object key) 方法, 在根据 key 查找时, 会根据 key 生成 hashVal, 再通过 hashVal 和 key 去判断 Map 内是否已存在对应的 key 了,
     *                              即 hashVal==oldHashVal && key.equals(oldKey)
     *                      结论:
     *                          在开发之中, Map 主要是用来查找, 优先考虑的 key 的类型为 String, 因为 String 这个类已实现了 hashCode() 和 equals() 且还实现了 Comparable 接口
     **/
    public void useSelfDefineObjectAsKey() {
        Map<String, Person> map = Maps.newHashMap();
        map.put(new String("ZS"), Person.builder().name("张三").build());
        System.out.println(map.get(new String("ZS")));

        Map<Person, String> map2 = Maps.newHashMap();
        map2.put(Person.builder().name("张三").build(), "ZS");
        System.out.println(map2.get(Person.builder().name("张三").build()));
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 14:49
     * @Description 利用 forEach() 方法迭代输出 Map
     **/
    public void loopOutputWithForEach() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        map.put(5, "e");
        map.forEach((k, v) -> System.out.print("{key=" + k + ", value=" + v + "}, "));
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 14:22
     * @Description 利用 Iterator 实现 Map 的迭代输出
     *                      问题:
     *                          1. 如何输出? 本质问题就是如何将 Map 对象转为 Iterator 对象, Iterator 集合是操作对象的, 那就得把 Map 中的键值对转为对象
     *                              1.1 观察 Map 内是有 entrySet() 方法, 通过改方法是可以返回 Set 集合的, 只不过 Set 集合中的对象被 Map.Entry<K,V> 包了一层
     *                              1.2 调用 Set 集合内的 iterator() 方法, 返回的是 Iterator<Map.Entry<K,V> 对象
     *                              1.3 再调用 Map.Entry<K,V> 内的 getKey() 和 getValue() 方法可以获取对应的 key 和 value
     **/
    public void loopOutputWithIterator() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        map.put(5, "e");
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iter = set.iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, String> entry = iter.next();
            System.out.print("{key=" + entry.getKey() + ", value=" + entry.getValue() + "}, ");
        }
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 13:42
     * @Description 观察 TreeMap 的排序操作
     *                      1. value 可以为 null, key 不能为 null
     *                      问题:
     *                          1. 为什么 key 不能为 null?
     *                              TreeMap 会根据 key 排序, key 为 null 还怎么排
     *                          2. 怎么排序的
     *                              在调用 TreeMap 的 put(K key, V value) 方法时, 底层会根据 key 进行排序, 先会将 key 强制转换为 Comparable 接口, 再调用 compareTo() 进行比较,
     *                              所以如果其 key 没有实现 Comparable 接口的话, 会报异常: key cannot be cast to Comparable
     **/
    public void treeMapOperation() {
        Map<Integer, String> map = new TreeMap<>();
        System.out.println("===============保存===============");
        map.put(7, "V7");
        map.put(3, "V3");
        map.put(1, "V1");
        System.out.println(map);
        System.out.println("===============key is null===============");
//        map.put(null, "hello");  // NPE
        System.out.println(map);
        System.out.println("===============value is null===============");
        map.put(999, null);
        System.out.println(map);
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 13:30
     * @Description 观察 Hashtable 相关方法操作
     *                      1. Hashtable 保存的键值对是无序的
     *                      2. key 和 value 都不能为 null, 否则会报 NPE
     **/
    public void hashtableOperation() {
        Map<String, Integer> map = new Hashtable<>();
        System.out.println("===============保存===============");
        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);
        System.out.println(map);
        System.out.println("===============key is null===============");
//        map.put(null, 4);  // NPE
        System.out.println("===============value is null===============");
//        map.put("empty", null);  // NPE
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 13:17
     * @Description 观察 HashMap 相关方法操作
     *                      1. Map 保存的键值对是无序的, 当然也可以通过 TreeMap 对 key 进行排序, 但 key 需事先 Comparable 接口, 否则会报异常
     *                      2. Map 中的 key 或 value 都可以为 null
     *                      3. 当保存的 key 相同时, 对应的 value 会被新的值覆盖
     **/
    public void hashMapOperation() {
        Map<String, Integer> map = new HashMap<>();
        System.out.println("===============保存===============");
        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);
        System.out.println(map);
        System.out.println("===============null===============");
        map.put("empty", null);
        map.put(null, 4);
        System.out.println(map);
        System.out.println("===============保存相同的key===============");
        map.put("first", 1111);
        System.out.println(map);
    }

    @Builder
    @ToString
    @EqualsAndHashCode
    private static class Person{
        private String name;
    }
}
