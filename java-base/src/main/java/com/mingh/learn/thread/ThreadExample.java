package com.mingh.learn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.stream.Stream;

/**
 * @ClassName ThreadExample
 * @Author Hai.Ming
 * @Date 2021/6/20 16:19
 * @Description 多线程 ★★★★★
 *                      1. 进程与线程的区别
 *                          1.1 DOS 系统有个特点: 只要电脑有病毒, 那么电脑就死机了。是因为 DOS 是单进程操作系统, 即在同一个时间段内, 只允许有一个程序运行。而后来到了 windows 时代,
 *                              电脑即使有病毒了也可使用, 但是会变慢。因为在一个 CPU, 一块资源的情况下, 程序利用一些轮转算法, 可以让一个资源在一个时间段上处理不同的程序(进程), 但是
 *                              在一个时间点上只允许有一个进程去执行。
 *                          1.2 在每一个进程上可以划分出若干个线程, 而线程的执行是要比进程更快的, 所以多线程的操作性能是要超过多进程。但是所有的线程都一定是要在进程的基础之上
 *                              进行划分, 即线程是依赖于进程而存在的。
 *                          1.3 每当使用 java 命令在 JVM 上解释某一个程序执行的时候, 那么都会默认启动一个 JVM 的进程, 而主方法只是这进程中的一个线程, 所以整个程序一直都跑在线程的运行
 *                              机制上。
 *                              每一个 JVM 至少会启动两个线程: 主线程, GC 线程
 *                      2. 在 Java 中对于多线程的实现一定要有个线程的主类, 而这个线程的主类往往是需要操作一些资源。但是对于这个多线程主类的实现是有一定要求的:
 *                          2.1 继承 Thread 父类(有单继承局限性)
 *                          2.2 实现 Runnable 接口(推荐使用)
 *                          2.3 实现 Callable 接口(对于要求线程有返回值的场景使用)
 *                      3. 所有的多线程执行都是并发进行的, 在同一个时间段上会有多个线程交替执行, 所以为了达到这样的目的, 绝对不能直接调用 run() 方法, 而是要调用 Thread 类中的 start()
 *                          方法来启动多线程。
 *                          思考: 为什么不能直接调用 run() 方法?
 *                          观察: Thread 类中的 start() 方法
 *                              1. 被 synchronized 修饰, 同步方法
 *                              2. 进入方法会有一个状态检查, 不为 0 会抛出一个运行时异常, 也就是说 0 这个状态为线程的初始状态, 不是 0 则说明线程已经被启动
 *                              3. 调用 private native void start0() 方法, 即由 Java 调用的一个非 Java 实现的方法。
 *                                  由于线程的启动需要牵扯到操作系统中资源分配的问题, 所以具体的线程的启动应该根据不同的操作系统来实现, 而 JVM 相当于根据系统中定义的 start0() 方法
 *                                  来处理不同系统的资源调度, 这样在多线程的层次上 start0() 方法名称不改变, 不同的系统有不同的实现。
 *                          结论: 只有 Thread 类中的 start() 方法才能进行操作系统的资源法分配, 所以启动多线程的方式永远都是调用 start() 方法实现
 *                      4. 两种实现方式的区别与联系
 *                          4.1 理解: 对于多线程的这两种实现方式: 继承 Thread 和实现 Runnable 接口, 从这两种模式的本质上来说, 一定要使用 Runnable 接口实现, 这样可以避免单继承实现带来的局限
 *                          性。除了这个使用原则之外, 还要清楚这两种实现方式的联系。
 *                          4.2 思考: 两种方式的实现有何联系?
 *                              观察: Thread 和 Runnable 的实现
 *                                  Thread implements Runnable --> start() --> 启动多线程
 *                                  MyThread implements Runnable --> run() --> 实现业务逻辑
 *                                  代理模式, 只不过方法名不一致, 但设计模式就是代理模式, 这是由于 Java 长期发展的产物。
 *                          4.3 区别与联系
 *                          a. 多线程的实现需要一个线程的主类, 这个类要么继承 Thread 类, 要么实现 Runnable 接口
 *                          b. 使用 Runnable 接口可以避免因继承 Thread 类而带来的单继承局限性
 *                          c. 使用 Runnable 接口可以比继承 Thread 类更好的实现数据共享操作(抢票)
 */
public class ThreadExample {

    public static void main(String[] args) throws Exception {
        // 继承 Thread 来实现多线程
//        MyThread1 mt1 = new MyThread1("线程A");
//        MyThread1 mt2 = new MyThread1("线程B");
//        MyThread1 mt3 = new MyThread1("线程C");
//        mt1.start();
//        mt2.start();
//        mt3.start();

        // 实现 Runnable 接口来实现多线程
//        MyThread2 mt1 = new MyThread2("线程A");
//        MyThread2 mt2 = new MyThread2("线程B");
//        MyThread2 mt3 = new MyThread2("线程C");
//        new Thread(mt1).start();
//        new Thread(mt2).start();
//        new Thread(mt3).start();
        // Lambda 写法
//        new Thread(() -> Stream.iterate(0, i -> ++i).limit(10).forEach(i -> System.out.println("Lambda, X=" + i))).start();

        // 通过 Callable 实现多线程
//        FutureTask<String> task1 = new FutureTask<>(new MyThread3("线程A"));
//        FutureTask<String> task2 = new FutureTask<>(new MyThread3("线程B"));
//        FutureTask<String> task3 = new FutureTask<>(new MyThread3("线程C"));
//        new Thread(task1).start();
//        new Thread(task2).start();
//        new Thread(task3).start();
//        Thread.sleep(100);
//        System.out.println("task1 execute result: " + task1.get());
//        System.out.println("task2 execute result: " + task2.get());
//        System.out.println("task3 execute result: " + task3.get());

        // 观察线程的命名及取的
        MyThread4 mt1 = new MyThread4();
        MyThread4 mt2 = new MyThread4();
        MyThread4 mt3 = new MyThread4();
        new Thread(mt1).start();
        new Thread(mt2).start();
        new Thread(mt3).start();
    }
}

/**
 * @Author Hai.Ming
 * @Date 2021/6/21 00:32
 * @Description 观察下线程的命名操作, 线程的休眠, 线程的优先级
 *                      线程的所有操作方法几乎都在 Thread 类中定义好了
 *                      1. 线程的命名和取的
 *                          1.1 从本质上来说, 多线程的运行状态并不是固定的, 要想确定线程的执行, 唯一的区别就在线程的名称上。在起名时尽可能避免重名, 或者避免改名
 *                          1.2 在 Thread 中有如下方法可以进行线程的命名及修改操作:
 *                              构造方法: public Thread(Runnable target, String name)
 *                              设置名字: public final void setName(String name)
 *                              取的名字: public final String getName()
 *                              既然线程的执行本身是不确定的状态, 所以如果要取的线程的名字的话, 那么唯一能做到的就是取得当前线程的名字: public static Thread currentThread(),
 *                              如果在设置线程对象时没有给定名称, 会有默认值
 **/
class MyThread4 implements Runnable{

    @Override
    public void run() {
        Stream.iterate(0, i -> ++i).limit(10).forEach(i -> System.out.println(Thread.currentThread().getName() + ", X=" + i));
    }
}

/**
 * @Author Hai.Ming
 * @Date 2021/6/21 00:01
 * @Description java.util.Callable JDK1.5
 *                      1. 实现 Callable 接口比较复杂, 要利用 FutureTask 来包装下 new FutureTask(Callable call)
 *                      2. FutureTask<V> 的两个构造器分别接收 Callable 类型的参数和 Runnable 类型的参数, 接收 Runnable 类型参数时还需指定返回值
 *                      3. FutureTask<V> 实现了 RunnableFuture<V> 接口, 而 RunnableFuture<V> 接口继承了 Runnable 和 Future<V> 接口
 *                      4. Thread 又实现了 Runnable 接口且 Thread 类的构造器接收 Runnable 类型的参数
 **/
class MyThread3 implements Callable<String> {

    private String name;

    public MyThread3(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Stream.iterate(0, i -> ++i).limit(10).forEach(i -> System.out.println(this.name + ", X=" + i));
        return Thread.currentThread().getName() + " execute done.";
    }
}

/**
 * @Author Hai.Ming
 * @Date 2021/6/20 22:27
 * @Description 实现 java.lang.Runnable 接口来实现多线程
 **/
class MyThread2 implements Runnable {

    private String name;

    public MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Stream.iterate(0, i -> ++i).limit(10).forEach(i -> System.out.println(this.name + ", X=" + i));
    }
}

/**
 * @Author Hai.Ming
 * @Date 2021/6/20 22:27
 * @Description 继承 java.lang.Thread 来实现多线程
 **/
class MyThread1 extends Thread {

    private String name;

    public MyThread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // 延迟计算, 需要先 ++
        Stream.iterate(0, i -> ++i).limit(10).forEach(i -> System.out.println(this.name + ", X=" + i));
    }
}
