package com.mingh.learn.reflect;

import com.mingh.learn.reflect.bean.Person;

import java.lang.reflect.Constructor;

/**
 * @ClassName ConstructorExample
 * @Author Hai.Ming
 * @Date 2021/6/14 23:43
 * @Description java.lang.reflect.Constructor ★★★★★
 */
public class ConstructorExample {

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
}
