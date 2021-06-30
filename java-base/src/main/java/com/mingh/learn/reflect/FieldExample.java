package com.mingh.learn.reflect;

import com.mingh.learn.reflect.bean.Person;

import java.lang.reflect.Field;

/**
 * @ClassName FieldExample
 * @Author Hai.Ming
 * @Date 2021/6/14 23:49
 * @Description java.lang.reflect.Field ★★★★★
 */
public class FieldExample {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/14 23:52
     * @Description 观察给对象内的公有属性和私有属性赋值
     *                      1. 使用 getDeclaredField(String name) 获取反射类中所有访问级别的属性
     *                      2. 使用 getField(String name) 获取反射类及其父类中 public 访问级别的属性
     *                      3. 对象中所有的属性几乎都要使用 private 封装, 调用 setAccessible(true) 可取消封装
     *
     **/
    public Person setField(String nameValue, int ageValue) throws Exception {
        Class<?> clazz = Class.forName("com.mingh.learn.reflect.bean.Person");
        Object obj = clazz.newInstance();
        Field ageField = clazz.getDeclaredField("age");
        ageField.set(obj, ageValue);
        Field nameField = clazz.getDeclaredField("name");
        if (!nameField.isAccessible()) {
            nameField.setAccessible(true);
        }
        nameField.set(obj, nameValue);
        return (Person) obj;
    }
}
