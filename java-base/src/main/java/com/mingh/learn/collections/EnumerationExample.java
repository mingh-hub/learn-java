package com.mingh.learn.collections;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @ClassName EnumerationExample
 * @Author Hai.Ming
 * @Date 2021/6/13 11:58
 * @Description java.util.Enumeration
 *                      1. JDK 1.0, 最早出现是为了 Vector 服务的, 所以 Collection, List里面都没有为 Enumeration 提供实例化的方法, 而 Vector 提供了: public Enumeration<E> elements()
 */
public class EnumerationExample {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 12:09
     * @Description Enumeration 循环遍历
     **/
    public void loop() {
        Vector<String> vector = new Vector<>();
        vector.add("a");
        vector.add("b");
        vector.add("c");
        vector.add("d");
        vector.add("e");
        Enumeration<String> enu = vector.elements();
        while (enu.hasMoreElements()) {
            System.out.print(enu.nextElement() + ", ");
        }
    }
}
