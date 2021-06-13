package com.mingh.learn.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

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
}
