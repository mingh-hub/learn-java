package com.mingh.learn.reflect.bean;

import com.mingh.learn.beans.BaseBean;

/**
 * @ClassName Person
 * @Author Hai.Ming
 * @Date 2021/6/14 14:35
 * @Description 反射用例对象
 */
public class Person extends BaseBean {

    /**
     * 私有属性-姓名
     **/
    private String name;
    /**
     * 公有属性-年龄
     **/
    public Integer age;

    public Person() {
        System.out.println("Person 类的无参构造方法执行了......");
    }

    public Person(String name) {
        System.out.println("Person 类的有参构造方法执行了......");
        this.name = name;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void publicStaticMethod() {
        System.out.println("Person 类的静态方法被调用了......");
    }

    private void privateMethod() {
        System.out.println("Person 类的私有方法被调用了......");
    }

    public void publicMethod() {
        System.out.println("Person 类的公有方法被调用了......");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
