package com.mingh.learn.io;

import com.mingh.learn.common.enums.ResultEnum;
import com.mingh.learn.common.exception.BusinessRuntimeException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

/**
 * @ClassName ReaderExample
 * @Author Hai.Ming
 * @Date 2021/6/1 20:38
 * @Description Reader 是字符输入流的抽象基类
 */
@Slf4j
public class ReaderExample {

    /**
     * @MethodName read
     * @Author Hai.Ming
     * @Date 2021/6/1 20:59
     * @Description 利用字符输入流读取数据
     **/
    public void read(String sourceFile) {
        File file = new File(sourceFile);
        if (!file.exists()) {
            throw new BusinessRuntimeException(ResultEnum.FILE_NOT_FOUND);
        }
        Reader reader = null;
        try {
            reader = new FileReader(file);
            // sourceFile=/Users/user/Desktop/test.txt
            log.info("file-getName()-{}", file.getName());  // test.txt
            log.info("file-getParent()-{}",file.getParent());  // /Users/user/Desktop
            log.info("file-getPath()-{}", file.getPath());  // /Users/user/Desktop/test.txt
            log.info("file-getAbsolutePath()-{}", file.getAbsolutePath());  // /Users/user/Desktop
            log.info("file-getParentFile()-{}", file.getParentFile());  // /Users/user/Desktop
            char[] data = new char[2048];
            int len;
            StringBuffer buffer = new StringBuffer();
            if ((len = reader.read(data)) != -1) {
                buffer.append(data, 0, len);
            }
            log.info("读取的数据为: {}", buffer.toString());
        } catch (Exception e) {
            log.error("数据读取异常", e);
        } finally {
            if (Objects.nonNull(reader)) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("字符输入流关闭失败", e);
                }
            }
        }
    }
}
