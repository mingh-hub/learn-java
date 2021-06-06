package com.mingh.learn.io;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @ClassName SerializableExample
 * @Author Hai.Ming
 * @Date 2021/6/6 23:39
 * @Version 1.0
 * @Description 序列化含义理解
 *                        1. 什么是序列化?
 *                          序列化指的是将在内存中保存的对象变为二进制数据流, 这样就意味着对象可以保存在磁盘文件中或者进行各种传输操作。
 *                        2. transient: 可标识序列化对象某些字段不被序列化
 */
@Slf4j
public class SerializableExample {

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/7 0:00
     * @Description:  反序列化
     */
    public Person getPerson(String sourceFilePath) throws Exception {
        log.info("Person 反序列化");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sourceFilePath));
        Person p = (Person) ois.readObject();
        log.info("Person 反序列化结果为: {}", p);
        return p;
    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/6 23:54
     * @Description:  序列化
     */
    public void savePerson(Person p, String targetFilePath) throws Exception {
        log.info("Person 序列化");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(targetFilePath));
        oos.writeObject(p);
        oos.close();
    }

    @Getter
    @Setter
    @Builder
    @ToString
    static class Person implements Serializable {
        private static final long serialVersionUID = -608519558041705066L;

        private String name;
        private Integer age;
//        private transient Integer age;
    }
}
