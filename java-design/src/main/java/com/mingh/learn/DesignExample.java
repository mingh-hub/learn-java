package com.mingh.learn;

/**
 * @ClassName DesignExample
 * @Author Hai.Ming
 * @Date 2021/6/23 23:28
 * @Version 1.0
 * @Description 设计模式 ★★★★★
 */
public interface DesignExample {

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/23 23:31
     * @Description:  设计模式产生背景
     * 1. 设计模式最初并不是出现在软件设计中, 而是被用于建筑领域的设计中
     * 2. 1990 年软件工程界开始研讨设计模式的话题, 后来召开了多次关于设计模式的研讨会。直到 1995 年, 由四位作者
     *     合作出版了<<设计模式: 可复用面向对象软件的基础>> 一书, 此书中收录了 23 种设计模式, 这是设计模式领域里
     *     程碑事件。这四位作者在软件开发领域以 GoF(Gong of Four) 著称。
     */
    void designBackground();

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/23 23:53
     * @Description:  设计模式优缺点
     * 1. 优点
     * a. 使程序设计更加标准化, 代码编制更加工程化; 提高开发效率, 缩短开发周期
     * b. 使代码重用性, 拓展性和维护性
     * c. 同时也可提高程序员的思维能力, 编程能力和设计能力
     * 2. 缺点
     * 增大工作量
     */
    void designFeature();

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/24 0:04
     * @Description:  设计模式分类
     * 1. 创建型模式
     *  用于描述如何创建对象, 主要特点是将对象的创建和使用分离。
     *  GoF 书中提供了: 单例, 原型, 工厂方法, 抽象工厂, 建造者 5 种创建型模式
     * 2. 结构型模式
     * 用于描述如何将类或对象按照某种布局组成更大的结构。
     * GoF 书中提供了: 代理, 适配器, 桥接, 组合, 装饰, 亨元, 外观 7 种结构型模式
     * 3. 行为型模式
     * 用于描述类或对象之间怎样协作完成单个对象无法完成的任务, 以及如何分配职责。
     * GoF 书中提供了: 模板方法, 策略, 命令, 职责链, 状态, 观察者, 中介者, 访问者, 迭代器, 解释器, 备忘录 11 种行为型模式
     */
    void designModel();

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/24 0:26
     * @Description:  六大设计原则 ★★★★★
     *
         * 一. 开闭原则
     * 1. 对扩展开放, 对修改关闭
     * 如何理解? 在程序需要拓展的时候, 不能去修改原有的代码, 实现一个热插拔的效果
     * 如何实现? 一般会使用接口和抽象类去达到这样的 效果
     *
     * 二. 里氏替换原则
     *  定义1: 如果对每一个类型为 T1 的对象 o1, 都有类型为 T2 的对象o2, 使得以 T1 定义的所有程序 P 在所有的对象 o1 都代换成 o2 时, 程序 P 的行为没有发生变化, 那么类型 T2 是类型 T1 的子类型
     *  定义2: 所有引用基类的地方必须能透明地使用其子类的对象
     *  应用: 面向对象三大特性之一的继承要遵循里氏替换原则。
     *      a. 继承包含了一层含义: 父类中凡是已经实现好的方法(相对于抽象方法而言), 实际上是在设定一系列的规范和契约, 虽然父类没有要求所有子类遵循这些规范和契约, 但是如果
     *          子类对这些非抽象方法任意修改, 就会对整个继承体系造成破坏。而里氏替换原则就是表达了这一层含义。
     *      b. 继承作为面向对象的三大特性之一, 在给程序设计带来巨大便利的同时, 也带来了弊端。比如使用继承会给程序带来侵入性, 使程序的可移植性降低, 增加了对象之间的耦合性。
     *          比如当一个类被其它类继承, 当这个类需要修改时, 必须要考虑子类。eg, JDK1.8 在 java.lang.Iterable 中新增了 forEach() 方法, 为了不对其子类产生影响, 用了 default 来修饰。
     *
     * 三. 依赖倒转原则
     *
     * 四. 接口隔离原则
     *
     * 五. 迪米特法则
     *
     * 六. 合成复用原则
     */
    void designPrinciple();
}