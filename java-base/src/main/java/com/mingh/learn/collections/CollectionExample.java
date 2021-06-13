package com.mingh.learn.collections;

import com.google.common.collect.Lists;
import com.mingh.learn.beans.User;
import com.mingh.learn.common.enums.ResultEnum;
import com.mingh.learn.common.exception.BusinessRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Iterator;

/**
 * @ClassName CollectionExample
 * @Author Hai.Ming
 * @Date 2021/6/9 20:06
 * @Description java.util.Collection JDK1.2 ★★★★★
 *                      1. 为什么会出现类集的概念?
 *                      问题: 在所有的开发之中, 都不可避免的会出现一个问题, 数组长度有限。(数组长度可修改, 如何改? 通过反射完成, 但操作太复杂)。
 *                              而且在数组中进行数据维护也是非常困难的, 例如: 删除后再添加。正因为数组的操作不方便, 所以在开发中数组出现的情况很少。
 *                              如果想要摆脱数组操作的一切困扰, 首先可以想到的是数据结构, 可以使用数据链表来完成。但自定义链表实现起来有如下困难:
 *                              a. 链表的实现对初学者来说难度较高
 *                              b. 如果要想实现一个高性能链表会比较麻烦
 *                              c. 链表之中虽然可以使用 Object 接收, 但是依然会存在强制转型问题
 *                      解决: 在最早的 Java 时代(JDK1.0)为了解决这个问题, 提供了一系列的处理类: Vector, Stack, Hashtable, Enumeration; 在随后的 JDK1.2 开始,
 *                              正式引入了类集框架的概念(Collection, List, Set, Map, Iterator 等), Java 就可以很方便的实现动态数组操作; JDK1.5 之后, 由于泛型技术的使用,
 *                              类集就避免了 Object 类对程序的影响。到了 JDK1.8 时代, 类集又发了变化, 支持了数据流操作, 或者说支持了 MapReduce 操作。
 *                              对于数据结构而言, Node 类的存在是至关重要的。
 *                      2. 类集的本质是什么?
 *                          动态对象数组
 *                      3. 什么是 Collection? 是负责进行单值保存的最大父接口。
 *                          |- List: 允许保存重复元素, 数据的保存顺序就是数据的增加顺序(有序)
 *                          |- Set: 不允许保存重复元素, 并且内部的元素可以调整(无序)
 *                      3. Collection 和 Collections 的区别
 *                          3.1 Collection 是集合操作的父接口, 可以保存单值数据; 而 Collections 则是集合操作的工具类, 可以操作 List, Set, Map, 里面的一些方法还是比较
 *                              有意思的, 比如 addAll(), reverse(), binarySearch() etc.
 */
@Slf4j
public class CollectionExample {

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/10 1:02
     * @Description:  使用迭代器输出元素
     */
    public void iterator(Collection<User> coll) {
        if (CollectionUtils.isEmpty(coll)) {
            throw new BusinessRuntimeException(ResultEnum.PARAMS_IS_MISSING);
        }
        Iterator<User> iterator = coll.iterator();
        while (iterator.hasNext()) {
            log.info("User: {}", iterator.next());
        }
    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/10 0:41
     * @Description:  从集合中删除指定对象, 需要 equals() 方法支持
     */
    public Collection<User> remove(User user) {
        Collection<User> collection = Lists.newArrayList();
        collection.add(User.builder().chName("张三").age(22).build());
        collection.remove(user);
        return collection;
    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/10 0:33
     * @Description:  集合中是否包含指定对象, 需要重写 equals() 方法支持
     */
    public boolean contains(User user) {
        Collection<User> collection = Lists.newArrayList();
        collection.add(User.builder().chName("张三").age(22).build());
        return collection.contains(user);
    }
}
