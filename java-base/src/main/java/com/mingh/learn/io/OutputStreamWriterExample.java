package com.mingh.learn.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @ClassName OutputStreamWriterExample
 * @Author Hai.Ming
 * @Date 2021/6/2 20:08
 * @Description java.io.OutputStreamWriter 是字符流通向字节流的桥梁：可使用指定的 charset 将要写入流中的字符编码成字节（编码）。
*                       它使用的字符集可以由名称指定或显式给定，否则将接受平台默认的字符集。
 */
public class OutputStreamWriterExample {

    /**
     * @MethodName transferCharToByte
     * @Author Hai.Ming
     * @Date 2021/6/2 20:30
     * @Description 将字符按指定编码转换成字节流存储到缓冲区, 最后刷新到文件
     **/
    public void transferCharToByte(String targetFile, String content, String charsetName) throws Exception {
        // 处理文件
        File file = new File(targetFile);
        if (!file.getParentFile().exists()) {
            file.createNewFile();
        }
        // 构建字节输出流
        OutputStream os = new FileOutputStream(file);
        // 通过 OutputStream 来构建字符输出流, 根据 JDK 文档建议用 BufferedWriter 包装后会提高效率
        Writer writer = new BufferedWriter(new OutputStreamWriter(os, Charset.forName(charsetName)));
        // 字符转换为字节存储到缓冲区中（指定编码）
        writer.write(content);
        // 将内存缓冲区的字节流刷新到目标文件
        writer.flush();
        // 关闭流
        writer.close();
    }
}
