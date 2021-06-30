package com.mingh.learn.io;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName BufferedReaderExample
 * @Author Hai.Ming
 * @Date 2021/6/6 20:40
 * @Version 1.0
 * @Description 缓冲字符输入流
 *                        JDK 1.1 提供的, 虽然很好用, 但现在并不是首要选择, 首选用 java.util.Scanner
 */
@Slf4j
public class BufferedReaderExample {

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/6 21:31
     * @Description:  读取控制台的输入信息只能用 main() 函数来测
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入信息: ");
        System.out.println("输入信息为: " + reader.readLine());
        reader.close();
    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/6 20:54
     * @Description:  测试缓冲字符输入流的 readLine() 方法, 这个方法可以读入大文本数据
     */
    public void readLine(@NonNull String sourcePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
        // 这种输出会出现问题, 除第一行外, 其它行首字符会丢失
//        printLineError(reader);
        // 正确输出
        printLineRight(reader);
        reader.close();
    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/6 21:23
     * @Description:  正确读法
     */
    private void printLineRight(BufferedReader reader) throws IOException {
        String content;
        while ((content = reader.readLine()) != null) {
            log.info("缓冲字符输入流读取的数据为: {}", content);
        }
    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/6 21:06
     * @Description:   除第一行外, 其它行首字符会丢失: 原因是 reader.read() 执行时会先读一个字符
     */
    private void printLineError(BufferedReader reader) throws IOException {
        String content;
        do {
            content = reader.readLine();
            log.info("缓冲字符输入流读取的数据为: {}", content);
        } while (reader.read() != -1);
    }
}
