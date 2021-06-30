package com.mingh.learn.io;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @ClassName ByteArrayInputStreamExample
 * @Author Hai.Ming
 * @Date 2021/6/6 14:14
 * @Version 1.0
 * @Description 1. 字节内存流: 分为字节内存输入流(ByteArrayInputStream)和字节内存输出流(ByteArrayOutputStream)
 *                          以文件操作为例, 文件为终端:
 *                              输出(OutputStream): 程序 >>  OutputStream >> 文件
 *                              输入(InputStream): 程序 <<  InputStream << 文件
 *                          以内存操作为例, 内存为终端:
 *                              输出(InputStream): 程序 >> InputStream >> 内存
 *                              输入(OutputStream): 程序 << OutputStream << 内存
 *                        2. 什么是内存流?
 *                              内存流是将流的输入输出位置放到内存上,而不是建立在内存和外部设备之间,此时的操作应该以内存为操作点
 *                        3. 内存流应用场景?
 *                              文件流的操作特点是需要以文件为操作终端, 如果在开发中不需要产生文件但依然需要进行 IO 操作(如网络传输将文件放到内存),
 *                              这个时候可以考虑使用内存流
 */
@Slf4j
public class ByteArrayInputStreamExample {

    /**
     * @Author: Hai.Ming
     * @Date: 2021/6/6 14:21
     * @Description: 将输入内容大写后再保存到内存中
     */
    public String write(@NonNull String content) throws Exception {
        // 将内容保存到内存流中
        ByteArrayInputStream bais = new ByteArrayInputStream(content.getBytes());
        // 将所有的内存流数据取出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 保存每次读进来的字节数据
        int len;
        while ((len = bais.read()) != -1) {
            baos.write(Character.toUpperCase(len));
        }
        log.info("将输入内容大写后保存在内存中的结果为: {}", baos);
        bais.close();
        baos.close();
        return baos.toString();
    }
}
