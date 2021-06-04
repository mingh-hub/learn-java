package com.mingh.learn.io;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;

/**
 * @ClassName BufferedOutputStreamExample
 * @Author Hai.Ming
 * @Date 2021/6/5 0:00
 * @Version 1.0
 * @Description 缓冲输出字节流
 */
@Slf4j
public class BufferedOutputStreamExample {

    /**
     * @Author: Hai.Ming
     * @Date: 2021/6/5 0:02
     * @Description: 通过缓冲输出字节流向目标文件写数据
     */
    public void write(String targetPath, String content) throws Exception {
        Objects.requireNonNull(targetPath);
        Objects.requireNonNull(content);
        // 判断目标文件是否存在, 若不存在则创建
        File file = new File(targetPath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        // 通过文件输出字节流创建缓存输出字节流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        // 字节输出
        bos.write(content.getBytes());
        bos.flush();
        bos.close();
    }
}
