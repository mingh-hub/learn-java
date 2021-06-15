package com.mingh.learn.collections;

import com.mingh.learn.beans.BaseBean;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;

/**
 * @ClassName ArraysExample
 * @Author Hai.Ming
 * @Date 2021/6/15 19:28
 * @Description java.util.Arrays JDK1.2 ★★★★
 *                      数组操作类, 观察下数据内的一些常用方法
 *                      1. toString()
 *
 */
public class ArraysExample {



    /**
     * @Author Hai.Ming
     * @Date 2021/6/15 23:48
     * @Description 数组填充
     **/
    public Person[] fill(Person p) {
        Person[] pArray = new Person[3];
        Arrays.fill(pArray, p);
//        Arrays.fill(pArray, 0, 1, p);
        System.out.println(Arrays.toString(pArray));
        return pArray;
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/15 23:34
     * @Description 观察自定义对象的数组比较
     *                      1. 内部是调用对象的 equals() 方法进行比较, 数组内对象需要重写 equals() 方法
     **/
    public boolean equals(Person[] pa) {
        Person[] personArray = {Person.builder().name("张三").age(22).build()};
        return Arrays.equals(personArray, pa);
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/15 22:55
     * @Description 二分查找
     *                      1. 返回负数表示没找到
     *                      2. 二分查找的时候会将传入的 key 强制转成 Comparable 接口, 然后再调用 compareTo 方法进行比较, 所以数组内的对象必须实现 Comparable 接口,
     *                          和 Collections.binarySearch() 逻辑相同
     *                      3. 无论是基本数据类型还是自定义类型都得实现自然排序, 否则结果不准
     **/
    public int binarySearch(Person p) {
        // 自定义对象
        Person[] personArray = {Person.builder().name("张三").age(22).build(),
                Person.builder().name("王五").age(12).build(),
                Person.builder().name("李四").age(28).build()};
        Arrays.sort(personArray);  // 张三-->李四-->王五
        System.out.println("张三".compareTo("李四"));  // -2094
        System.out.println("张三".compareTo("王五"));  // -5227
        System.out.println("李四".compareTo("王五"));  // -3133
        System.out.println(Arrays.toString(personArray));
        return Arrays.binarySearch(personArray, p);
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/15 22:49
     * @Description 观察下 toString 方法
     *                      调用数组内元素的 toString 方法
     **/
    public void arrayToString() {
        // 基本数据类型
        int[] intArray = {1, 3, 99, 45, 32, 8};
        System.out.println(Arrays.toString(intArray));
        // 自定义对象
        Person[] personArray = {Person.builder().name("张三").age(22).build(), Person.builder().name("李四").age(28).build()};
        System.out.println(Arrays.toString(personArray));
    }

    @Builder
    @Getter
    static class Person extends BaseBean implements Comparable<Person> {
        private String name;
        private int age;

        @Override
        public int compareTo(Person o) {
            if (this.name.compareTo(o.getName()) > 0) {
                return 1;
            } else if (this.name.compareTo(o.getName()) < 0) {
                return -1;
            } else {
                return this.age - o.age;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Person)) {
                return false;
            }
            Person p = (Person) obj;
            return this.name.equals(p.getName()) && this.age == p.getAge();
        }
    }
}
