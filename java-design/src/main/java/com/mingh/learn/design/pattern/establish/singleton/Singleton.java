package com.mingh.learn.design.pattern.establish.singleton;

/**
 * @ClassName Singleton
 * @Author Hai.Ming
 * @Date 2021/7/4 21:44
 * @Description 设计模式之单例模式(Singleton-创建型模式)
 *                      定义:
 *                          某个类只能生成一个实例, 该类提供了一个全局访问点供外部获取该实例。
 *                      解决:
 *                          一个全局使用的类被频繁的创建与销毁
 *                      优点:
 *                          1. 只有一个实例, 节约内存资源, 提高系统性能
 *                          2. 省去了 new 操作符, 降低了系统内存的使用频率, 减轻GC压力
 *                      缺点:
 *                          1. 没有抽象层, 不能扩展
 *                          2. 职责过重, 违背了单一职责原则
 *                          3. 在多线程条件下需要特殊处理, 避免多个线程多次创建单例对象
 *                      应用场景:
 *                          1. 数据库资源链接
 *                          2. 操作同一资源文件
 *                          3. 序列号生成
 *                      问题:
 *                          1. 如何实现延迟加载?
 *                              1.1 延迟初始化。如下, instance 初始化赋值为 null, 再通过静态工厂方法创建实例
 *                              1.2 代理模式实现
 *                              1.3 保值器
 *                              1.4 备份
 *                          2. 多线程环境下如何保证单例模式的安全问题?
 *                              volatile + 双端检索机制
 */
public class Singleton {

    /**
     * 私有静态实例, 防止被引用
     * 此处赋值为 null, 目的是实现延迟加载
     */
    private static volatile Singleton instance = null;

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
     * @Description 静态工厂方法创建实例, 提供一个全局入口(单线程)
     **/
    public static Singleton getInstanceForSingleThread() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 静态工厂方法创建实例, 提供一个全局入口(多线程)
     * 建议使用双端检索机制, 但在多线程并发的情况下并不一定线程安全。原因是因为指令重排序的存在。
     * 所以加入 volatile 禁止指令重排序
     * @return 全局唯一实例对象
     */
    public static Singleton getInstanceForMultiThread() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
