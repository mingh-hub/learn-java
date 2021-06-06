package com.mingh.learn.io;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @ClassName PrintStreamExample
 * @Author Hai.Ming
 * @Date 2021/6/6 19:07
 * @Version 1.0
 * @Description 打印流(PrintStream, PrintWriter) ★★★★★
 *                        1. 打印流设计思想
 *                              如果要进行数据的输入使用 InputStream, 输出使用 OutputStream, 可是在现实的环境中我们会发现一些问题,
 *                              OutputStream 或 InputStream 只能受限于字节数组类型。如果想要输出 String, int, double 类型的数据, 需要
 *                              先转成字节数组再输出
 *                        2. 什么是打印流?
 *                              基于上述问题, 出现了运用装饰设计模式设计而出的打印流, 可以打印各种类型的数据。本质没有改变, 只是使用起来方便了,
 *                              弥补了 OutputStream 的不足
 *                        2. 什么时候打印流?
 *                              如果以后需要进行内容的输出操作, 那么使用最方便的一定是打印流。
 *                              在以后的开发之中, 如果程序要输出文字信息, 就是用打印流; 如果只给个 InputStream 就使用 OutputStream
 */
public class PrintStreamExample {

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/6 19:44
     * @Description:  格式化输出
     */
    public void printf(String content, String targetPath) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream(targetPath), true);
        ps.printf("输出到文件的内容为: %s", content);
        ps.close();
    }

    /**
     * @Author: Hai.Ming
     * @Date: 2021/6/6 19:33
     * @Description: 将给定内容输出到目标文件
     */
    public void print(String content, String targetPath) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream(targetPath), true);
        ps.print(content);
        ps.close();
    }

    /**
     * @Author: Hai.Ming
     * @Date: 2021/6/6 19:28
     * @Description: 将给定内容输出到控制台
     */
    public void print(String content) throws Exception {
        PrintStream ps = new PrintStream(System.out);
        ps.println(content);
        ps.close();
    }
}
