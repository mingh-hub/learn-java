package com.mingh.learn.io;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @ClassName BufferedInputStreamExample
 * @Author Hai.Ming
 * @Date 2021/6/5 10:32 上午
 * @Description 缓冲字节输入流
 *
 */
@Slf4j
public class BufferedInputStreamExample {

    /**
     * @MethodName read
     * @Author Hai.Ming
     * @Date 2021/6/5 10:34 上午
     * @Description 从源文件读入数据
     **/
    public void read(String sourcePath) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
        byte[] data = new byte[3];
        int len;
        StringBuffer buffer = new StringBuffer();
        while ((len = bis.read(data)) != -1) {
            buffer.append(new String(data, 0, len));
        }
        log.info("BufferedInputStream read result is {}", buffer);
        bis.close();
    }
}
