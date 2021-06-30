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
     *      a. 使程序设计更加标准化, 代码编制更加工程化; 提高开发效率, 缩短开发周期
     *      b. 使代码重用性, 拓展性和维护性
     *      c. 同时也可提高程序员的思维能力, 编程能力和设计能力
     * 2. 缺点
     *      增大工作量
     */
    void designFeature();

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/24 0:04
     * @Description:  设计模式分类
     * 1. 创建型模式
     *  用于描述如何创建对象, 主要特点是将对象的创建和使用分离。
     *  GoF 书中提供了:
     *      单例, 原型, 工厂方法, 抽象工厂, 建造者 5 种创建型模式
     * 2. 结构型模式
     * 用于描述如何将类或对象按照某种布局组成更大的结构。
     * GoF 书中提供了:
     *      代理, 适配器, 桥接, 组合, 装饰, 亨元, 外观 7 种结构型模式
     * 3. 行为型模式
     * 用于描述类或对象之间怎样协作完成单个对象无法完成的任务, 以及如何分配职责。
     * GoF 书中提供了:
     *      模板方法, 策略, 命令, 职责链, 状态, 观察者, 中介者, 访问者, 迭代器, 解释器, 备忘录 11 种行为型模式
     */
    void designModel();

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/24 0:26
     * @Description:  设计模式的七大原则 ★★★★★
     *
     * 参考:
     *      https://blog.csdn.net/yucaixiang/article/details/90239817
     *
     */
    void designPrinciple();
}

/**
 * @Author Hai.Ming
 * @Date 2021/6/29 00:19
 * @Description 开闭原则-OCP(Open Closed Principle)
 * 定义:
 *      一个软件实体应当对扩展开放，对修改关闭
 * 问题由来:
 *      任何软件都会随着需求的变更而进行迭代更新。因为变化, 升级, 维护等原因, 如果对原有代码进行修改, 就可能导致原有逻辑处理出错, 需要对原有功能进行测试,
 *      所以当软件需要迭代更新时, 应尽量通过拓展软件实体的方法来满足需求, 而不是通过修改原有代码
 * 理解:
 *      1. 为了满足开闭原则, 需要对系统进行抽象化设计, 抽象化是开闭原则的关键。在 Java 中, 抽象化的关键就是接口和抽象类
 *      2. 在软件设计过程中, 需要为系统定义一个相对稳定的抽象层, 将不同的实现移至具体的实现层中完成。
 * 优点:
 *      1. 开闭原则非常有名, 只要是面向对象编程, 在开发时都会强调开闭原则
 *      2. 开闭原则是最基础的设计原则, 其它五个原则都是开闭原则的具体形态。可以理解为开闭原则是抽象类, 而其它五个原则是具体实现类
 *      3. 提高了系统的可拓展性和可维护性, 符合面向对象的开发需求
 * 使用原则:
 *      1. 抽象约束: 抽象是对一组事物的通用描述, 没有具体的实现, 也就表示它可以有非常多的可能性。因此, 通过接口或抽象类可以约束一组可能变化的行为,
 *        并且能够实现对扩展开放, 其包含三层定义:
 *          a. 通过接口或抽象类约束扩散, 对扩展进行边界限定, 不允许出现在接口或抽象类中不存在的 public 方法
 *          b. 参数类型, 引用对象尽量使用接口或抽象类, 而不是实现类。这主要是实现里氏代换原则的一个要求
 *          c. 抽象层尽量保持稳定, 一旦确定就不要修改
 *      2. 元数据空间模块行为
 *          为了减少重复开发, 尽量使用元数据来控制程序行为。
 *          那什么是元数据? 用来描述环境和数据的数据, 也就是配置参数, 参数可以从配置中获取也可从数据库中获取
 *      3. 制定项目章程
 *          约定优于配置, 这比通过接口和抽象类进行约束效率更高, 扩展性一点也没少
 *      4. 封装变化: 将相同的变化封装到同一个接口或抽象类中, 意味着不同的变化要封装到不同的接口或抽象类中
 *          如何理解相同的变化? 我理解是一个原子动作所引起的一些列状态变更或行为变化
 **/
class OCP {

}

/**
 * @Author Hai.Ming
 * @Date 2021/6/29 00:20
 * @Description 单一职责原则-SRP(Single Responsibility Principle)
 * 定义:
 *      一个类只负责一个功能领域中的相应职责
 * 问题由来:
 *      T 类负责两个不同的职责, 分别为 R1 和 R2, 当职责 R1 发生需求变更时, 可能导致职责 R2 运行故障
 * 理解:
 *      1. 如果一个类(大到模块, 小到方法)承担的职责越多, 那么被复用的可能性就越低
 *      2. 如果一个类承担的职责过多, 就相当于将这些职责耦合在一起, 当其中一个职责发生变化时, 就可能会影响到其它职责运行, 需要对这些职责进行分离
 *      3. 单一职责原则是实现高内聚, 低耦合的指导方针, 理解简单单运用起来就不简单了
 * 优点:
 *      1. 降低类的复杂度, 使逻辑更加清晰
 *      2. 提高代码的可读性和可扩展性以及系统的可维护性
 *      3. 降低因修改某一职责导致其它职责运行故障的可能性
 **/
class SRP {

}

/**
 * @Author Hai.Ming
 * @Date 2021/6/29 00:20
 * @Description 里氏代换原则-LSP(Liskov Substitution Principle)
 *  定义:
 *      1. 如果对每一个类型为 T1 的对象 o1, 都有类型为 T2 的对象o2, 使得以 T1 定义的所有程序 P 在所有的对象 o1 都代换成 o2 时, 程序 P 的行为没有发生变化, 那么类型 T2 是
 *          类型 T1 的子类型
 *      2. 所有引用基类的地方必须能透明地使用其子类的对象
 *  优缺点: 面向对象三大特性之一的继承要遵循里氏代换原则。
 *      a. 继承包含了一层含义: 父类中凡是已经实现好的方法(相对于抽象方法而言), 实际上是在设定一系列的规范和契约, 虽然父类没有要求所有子类遵循这些规范和契约, 但是如果
 *          子类对这些非抽象方法任意修改, 就会对整个继承体系造成破坏。而里氏代换原则就是表达了这一层含义。
 *      b. 继承作为面向对象的三大特性之一, 在给程序设计带来巨大便利的同时, 也带来了弊端。比如使用继承会给程序带来侵入性, 使程序的可移植性降低, 增加了对象之间的耦合性。
 *          比如当一个类被其它类继承, 当这个类需要修改时, 必须要考虑子类。eg, JDK1.8 在 java.lang.Iterable 中新增了 forEach() 方法, 为了不对其子类产生影响, 用了 default 来修饰。
 *      c. 整体上来看是利大于弊的
 *  使用原则:
 *      1. 子类必须实现父类中声明的所有方法, 在编码中我们通常使用父类来声明一个对象, 如果一个方法只存在于子类中, 那么则无法在以父类定义的对象中使用
 *      2. 根据里氏代换原则的定义, 在任何使用基类对象的地方都可以使用子类对象, 因此程序中应尽量使用基类来定义对象。在运行时再确定其子类类型, 用子类
 *          对象来替换父类对象, 后面就通过新增代替修改来很方便的扩展系统的功能。里氏代换原则是实现开闭原则的重要方式之一。
 **/
class LSP {

}

/**
 * @Author Hai.Ming
 * @Date 2021/6/29 00:22
 * @Description 依赖倒置原则-DIP(Dependence Inversion Principle)
 *  定义:
 *      核心思想是面向接口编程。具体体现在两个方面:
 *      1. 高层模块不应该依赖底层模块, 两者都应该依赖其抽象
 *      2. 抽象不应该依赖细节, 细节应该依赖抽象
 *  理解:
 *      1. 依赖倒置原则要求我们在程序代码中传递参数时或在关联关系中, 尽量引用层次高的抽象层类, 即使用接口或抽象类来进行变量类型声明, 参数类型声明, 方法返回类型声明,
 *          数据类型转换等, 而不要使用具体类来做这些事情。为了确保原则的使用, 还要遵循 LSP 原则, 不要在子类中增加新的方法。
 *      2. 引入抽象层后, 系统具有很好的灵活性, 在程序中应尽量使用抽象层进行编程, 而将具体类写在配置文件中, 这样一来, 如果系统行为发生变化, 只需要对抽象层进行扩展, 并
 *          修改配置文件, 并不需要修改源系统代码。对扩展开放, 对修改关闭, 很好的满足了开闭原则
 *      3. 在实现 DIP 时, 我们只需要针对抽象层编程, 而将具体类的对象通过依赖注入的方式注入到其它对象中。依赖注入指当一个对象要与其他对象发生依赖关系时, 通过抽象来注
 *          入所依赖的对象。
 *  优点:
 *      1. 降低类与类之间的耦合性, 提高系统稳定性
 *      2. 提高代码的可读性和可维护性
 *  实现:
 *      1. 每个类尽量提供接口或抽象类, 或两者都具备
 *      2. 变量的声明类型尽量是接口或者抽象类
 *      3. 任何类都不应该从具体类派生
 *      4. 使用继承时尽量遵循里氏代换原则
 **/
class DIP {

}

/**
 * @Author Hai.Ming
 * @Date 2021/6/29 08:28
 * @Description 接口隔离原则-ISP(Interface Segregation Principle)
 *  定义:
 *      使用多个专门的接口, 而不使用单一总接口, 即客户端不应该依赖那些它不需要的接口。
 *  理解:
 *      1. 如果把"接口"理解成一个类型所提供的所有方法特征的时候, 这就是一种逻辑上的概念, 接口的划分将直接带来类型的划分。可以把接口理解成角色, 一个接口只能代表
 *          一个角色, 每个角色都有它特定的一个接口, 这个原则就可以叫做角色隔离原则
 *      2. 如果把"接口"理解成狭义的特定语言的接口, 那么 ISP 所表达的意思就是接口仅仅提供客户端需要的行为, 客户端不需要的行为则隐藏起来, 应当为客户端提供尽可能小的
 *          单独的接口。
 *      3. 接口应该尽量细化, 同时接口中的方法应该尽量少, 每个接口只包含一个客户端(子模块或业务逻辑类)所需的方法即可
 *  优点:
 *      1. 将一个接口分解为多个粒度小的接口, 可以预防外来接口的扩散(向一个接口中添加方法, 势必会导致其实现类都要实现该方法, JDK1.8 使用 default 关键字可避免), 提高
 *          系统的灵活性和可维护性
 *      2. 如果接口的粒度大小定义合理, 就能够有效的保证系统的稳定性。如果定义过小, 则会造成系统接口数量过多, 使设计复杂化; 如果定义过大, 则会大大降低系统的灵活性,
 *          无法提供定制服务
 *      3. 接口隔离不但提高了系统的内聚性, 减少了对外交互, 还降低了系统的耦合性
 *      4. 使用多个专门的接口可以体现对象的层次性, 因为可以通过接口的继承实现对总接口的定义
 *      5. 减少代码冗余。因为过大的接口中通常会放置许多不用的方法, 其实现类必须设计多余实现, 哪怕是空实现
 *  实现:
 *      1. 接口尽量要小, 但也要有限度。一个接口只服务于一个子模块或业务逻辑
 *      2. 了解环境, 不要盲目拆分。每个项目或产品都有特定的环境依赖, 环境不同, 接口拆分的标准也不同。拆分的方式是建立在深入了解业务逻辑的基础之上的。
 *      3. 为依赖接口的类定制服务。只提供调用者需要的方法, 屏蔽不需要的方法
 *      4. 提高内聚, 减少对外交互。提现在用最少的类做最多的事
 *  与单一职责对比:
 *      1. 单一职责注重的是职责, 而接口隔离注重的是对接口依赖的隔离
 *      2. 单一职责主要是约束类, 针对的是程序中的实现和细节; 而接口隔离主要是约束接口, 针对的是抽象和程序整体框架的构建
 **/
class ISP {

}

/**
 * @Author Hai.Ming
 * @Date 2021/6/29 23:30
 * @Description 迪米特法则-LoD(Law of  Demeter)
 *  定义:
 *      一个软件实体因尽可能少的与其它实体发生相互作用。
 *  理解:
 *      1. 迪米特法则(Law of Demeter, LoD) 又叫最少知识原则(Least Knowledge Principle, LKP)
 *      2. 如果两个软件实体无需直接通信, 那么就不应当发生直接的相互调用, 可以通过第三方转发该调用。其目的是降低类之间的耦合度, 提高模块的相对独立性
 *  优点:
 *      1. 迪米特法则要求限制软件实体之间通信的宽度和深度, 可以降低类之间的耦合度, 提高模块的相对独立性
 *      2. 耦合度的降低意味着类的可复用性和系统的扩展性得到提高
 *  实现:
 *      1. 在类的划分上, 应该创建弱耦合的类。因为创建的类与类之间的耦合越弱, 就越有利于实现可复用的目标
 *      2. 在类的设计上, 优先考虑将一个类设置成不可变类
 *      3. 在类的结构设计上, 应尽量降低类成员的访问权限
 *      4. 在对其它类的引用上, 将引用其它对象的次数降到最低
 *      5. 不暴露类的属性成员, 而提供对应的访问器(getter & setter)
 *      6. 谨慎使用序列化(Serializable)功能
 **/
class LoD{
    
}

/**
 * @Author Hai.Ming
 * @Date 2021/6/30 21:58
 * @Description 合成复用原则-CRP(Composite Reuse Principle)
 *  定义:
 *      尽量使用对象的组合/聚合, 而不是使用继承关系来达到软件的复用性
 *  思考: 为什么不推荐使用继承关系来达到软件的复用性
 *      在 LSP 原则中有说到, 继承要遵循里氏代换原则。继承固然能给程序带来巨大的便利, 但也有其局限性。如:
 *      1. 继承给程序带来了侵入性
 *      2. 使程序的可移植性降低
 *      3. 增加了对象之间的耦合性
 **/
class CRP {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/30 22:46
     * @Description 通过继承的方式来展现软件的复用性
     **/
    static class DBConnection{
        public String getConnection() {
            return "获取数据库连接";
        }
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/30 22:51
     * @Description 如果后续需求要更换数据库, 就得修改 DBConnection, 这个就违背了开闭原则
     **/
    static class ProductDao extends DBConnection {
        public void addProduct() {
            getConnection();
            System.out.println("DB operation");
        }
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/30 22:53
     * @Description 利用合成复用原则达到软件的复用性
     **/
    abstract static class CRPDBConnection {
        public abstract String getConnection();
    }

    static class MySqlDBConnection extends CRPDBConnection {
        @Override
        public String getConnection() {
            return "mysql";
        }
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/30 23:06
     * @Description 如果要更换成 Oracle 数据库, 直接增加一个 OracleDBConnection 即可。新增代替修改, 符合开闭原则
     **/
    static class OracleDBConnection extends CRPDBConnection{
        @Override
        public String getConnection() {
            return "oracle";
        }
    }

    static class CRPProductDao{

        private final CRPDBConnection connection;

        public CRPProductDao(CRPDBConnection connection) {
            this.connection = connection;
        }

        public void addProduct() {
            String database = connection.getConnection();
            System.out.println("get " + database + " database");
            System.out.println("product added to " + database);
        }
    }

    public static void main(String[] args) {
        CRPDBConnection connection = new OracleDBConnection();
        CRPProductDao dao = new CRPProductDao(connection);
        dao.addProduct();
    }
}
