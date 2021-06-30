package com.mingh.learn.reflect;

import com.mingh.learn.reflect.bean.Person;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;

/**
 * @ClassName MethodExample
 * @Author Hai.Ming
 * @Date 2021/6/14 14:32
 * @Description java.lang.reflect.Method ★★★★★
 */
public class MethodExample {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/14 23:01
     * @Description 观察通过反射调用当前类中的共有及私有方法
     *                      1. 反射类中公有方法通过 getMethod(String name, Class<?>... parameterTypes) 和 getDeclaredMethod(String name, Class<?>... parameterTypes) 都可获取
     *                      1. 若要获取反射类中的私有方法, 要用 getDeclaredMethod(String name, Class<?>... parameterTypes)
     *                      2. 直接通过反射调用私有方法会报错: java.lang.NoSuchMethodException, 得先设置私有方法的访问权限
     **/
    public void invokePrivateMethod() throws Exception {
        Class<?> clazz = Class.forName("com.mingh.learn.reflect.bean.Person");
        Object obj = clazz.newInstance();
        Method publicMethod = clazz.getMethod("publicMethod");
        publicMethod.invoke(obj);
        Method privateMethod = clazz.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);  // 私有方法调用前要先指明是否可被调用
        privateMethod.invoke(obj);
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/14 22:43
     * @Description 获取对象内的方法集合
     *                      思考: getMethods() 和 getDeclaredMethods() 有何区别?
     *                      1. getMethods() 可以获取反射类及其父类中所有的公共方法
     *                      2. getDeclaredMethods() 可获取当前类中的所有访问类型的方法, 但不可获取父类方法
     **/
    public void obtainMethods() throws Exception {
        Class<?> clazz = Class.forName("com.mingh.learn.reflect.bean.Person");
        Method[] m1 = clazz.getMethods();
        Method[] m2 = clazz.getDeclaredMethods();
        System.out.println("=============获取包含父类的方法在内的所有方法=============");
        System.out.println(Arrays.toString(m1));
        System.out.println("=============仅获取当前类的方法=============");
        System.out.println(Arrays.toString(m2));
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/14 14:38
     * @Description 给定属性名, 调用对应属性的 set 方法为对象属性赋值
     **/
    public Person invokeSetMethod(String name, String value) throws Exception {
        Class<?> clazz = Class.forName("com.mingh.learn.reflect.bean.Person");
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod(StringUtils.join("set", name.substring(0, 1).toUpperCase(Locale.ROOT), name.substring(1)), String.class);
        method.invoke(obj, value);
        return (Person) obj;
    }
}
