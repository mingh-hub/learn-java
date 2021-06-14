package com.mingh.learn.reflect;

import com.mingh.learn.reflect.bean.Person;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.util.Date;

/**
 * @ClassName ClassExample
 * @Author Hai.Ming
 * @Date 2021/6/13 22:14
 * @Description java.lang.Class JDK1.0 ★★★★★
 *                      1. 什么是反射?
 *                          有反就有正, 所谓的反, 就是通过对象找到它的来源。在程序中, 若想通过对象找到它的来源, 就必须依靠 Object 类提供的一个方法: getClass(),
 *                          返回对象所属的类。
 */
@Slf4j
public class ClassExample {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/14 14:12
     * @Description 调用类的指定构造实例化对象
     *                      思考: 为什么类要提供无参构造
     *                          1. 框架的底层都会用到反射技术, 虽然有参构造也可实例化对象, 但框架并不知道方法的参数个数和参数类型
     *                          2. 有参构造实例化对象要比调用无参构造麻烦一些
     **/
    public void instanceObjUseConstructorWithParams() throws Exception{
        Class<?> clazz = Class.forName("com.mingh.learn.reflect.bean.Person");
        Constructor<?> cons = clazz.getConstructor(String.class);
        Person p = (Person) cons.newInstance("张三");
        System.out.println(p);
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 23:03
     * @Description 调用类的无参构造实例化对象
     *
     **/
    public void instanceObjUseConstructorWithoutParams() throws Exception {
        Class<?> clazz = Class.forName("com.mingh.learn.reflect.bean.Person");
        Person p = (Person) clazz.newInstance();
        p.setName("张三");
        System.out.println(p);
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 22:29
     * @Description 观察实例化 Class 对象的几种方式
     *                      1. 利用 Object 类中的 getClass() 方法, 此种方式必须先有实例化对象才可使用
     *                      2. 利用 "类.class" 取得
     *                      3. 利用 Class.forName() 方法取得 ★★★★★
     *                          好处: 可以直接编写字符串!!!
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
