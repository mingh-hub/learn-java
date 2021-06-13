package com.mingh.learn.reflect;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @ClassName ClassExample
 * @Author Hai.Ming
 * @Date 2021/6/13 22:14
 * @Description java.lang.Object JDK1.0 ★★★★★
 *                      1. 什么是反射?
 *                          有反就有正, 所谓的反, 就是通过对象找到它的来源。在程序中, 若想通过对象找到它的来源, 就必须依靠 Object 类提供的一个方法: getClass(),
 *                          返回对象所属的类。
 */
@Slf4j
public class ClassExample {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 23:03
     * @Description 观察通过反射实例化对象
     *                      1. 反射实例化对象会调用对象的无参构造, 也就是说没有无参构造的类无法通过反射进行实例化
     **/
    public void instanceObj() throws Exception {
        Class<?> clazz = Class.forName("com.mingh.learn.reflect.Person");
        Person p = (Person) clazz.newInstance();
        System.out.println(p);
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 22:29
     * @Description 观察实例化 Class 对象的几种方式
     *                      1. 利用 Object 类中的 getClass() 方法, 此种方式必须先有实例化对象才可使用
     *                      2. 利用 "类.class" 取得
     *                      3. 利用 Class.forName() 方法取得 ★★★★★
     **/
    public void instanceClassObj() throws ClassNotFoundException {
        // 方式一
        Date date = new Date();
        Class<?> clazz1 = date.getClass();
        log.info("全名: {}", clazz1.getName());
        log.info("类名: {}", clazz1.getSimpleName());
        // 方式二
        Class<?> clazz2 = Date.class;
        log.info("全名: {}", clazz2.getName());
        log.info("类名: {}", clazz2.getSimpleName());
        // 方式三
        Class<?> clazz3 = Class.forName("java.util.Date");
        log.info("全名: {}", clazz3.getName());
        log.info("类名: {}", clazz3.getSimpleName());
    }
}

class Person {

    private String name;

    public Person() {
        System.out.println("Person 类的无参构造执行了......");
    }

    public Person(String name) {
        System.out.println("Person 类的有参构造执行了......");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
