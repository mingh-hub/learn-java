package com.mingh.learn;

import com.google.common.collect.Lists;
import com.mingh.learn.beans.BaseBean;
import lombok.Builder;
import lombok.Getter;

import java.lang.reflect.Array;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) {
//        Person person = Person.builder().name("王五").age(12).build();
//        Person[] array = new Person[1];
//        array[0] = person;
//        test(array);

        List<Person> list = Lists.newArrayList();
        Person p = Person.builder().name("王五").age(12).build();
        list.add(p);
        list.add(p);
        list.add(Person.builder().name("王五").age(12).build());
        System.out.println(p);
    }


    public static <T extends Comparable<T>> void test(T[] a) {
        T[] b = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length);
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        T min = null;
        boolean flag = true;
        for (int i = 0; i < b.length; i++) {
            if (flag) {
                min = b[i];
                flag = false;
            }
            if (b[i].compareTo(min) < 0) {
                min = b[i];
            }
        }

        System.out.println(min);
    }
}

@Builder
@Getter
class Person extends BaseBean implements Comparable<Person> {
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