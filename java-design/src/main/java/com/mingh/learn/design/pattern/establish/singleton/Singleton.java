package com.mingh.learn.design.pattern.establish.singleton;

/**
 * @ClassName Singleton
 * @Author Hai.Ming
 * @Date 2021/7/4 21:44
 * @Description 设计模式-单例模式
 *                      定义:
 *                          某个类只能生成一个实例, 该类提供了一个全局访问点供外部获取该实例。
 *                      优点:
 *                          1. 只有一个实例, 节约内存资源, 提高系统性能
 *                          2. 省去了 new 操作符, 降低了系统内存的使用频率, 减轻GC压力
 *                      缺点:
 *                          1. 没有抽象层, 不能扩展
 *                          2. 职责过重, 违背了单一职责原则
 *                      应用场景:
 *
 *                      问题:
 *                          1. 如何实现延迟加载?
 *                              1.1 延迟初始化。如下, instance 初始化赋值为 null, 再通过静态工厂方法创建实例
 *                              1.2 代理模式实现
 *                              1.3 保值器
 *                              1.4 备份
 *                          2. Java 如何保证对象在序列化前后保持一致?
 *
 */
public class Singleton {

    /**
     * 私有静态实例, 防止被引用
     * 此处赋值为 null, 目的是实现延迟加载
     */
    private static Singleton instance = null;

    /**
     * @Author Hai.Ming
     * @Date 2021/7/4 22:03
     * @Description 私有构造方法, 防止被实例化
     **/
    private Singleton() {
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/7/4 22:04
     * @Description 静态工厂方法创建实例
     **/
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
