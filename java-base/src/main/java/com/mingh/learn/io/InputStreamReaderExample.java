package com.mingh.learn.io;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @ClassName InputStreamReaderExample
 * @Author Hai.Ming
 * @Date 2021/6/2 20:50
 * @Description java.io.InputStreamReader 是字节流通向字符流的桥梁：它使用指定的charset读取字节并将其解码为字符（解码）。
 *                      它使用的字符集可以由名称指定或显式给定，或者可以接受平台默认的字符集。
 */
@Slf4j
public class InputStreamReaderExample {

    /**
     * @MethodName transferByteToChar
     * @Author Hai.Ming
     * @Date 2021/6/2 20:56
     * @Description 将文件中保存的字节流以指定编码格式读入, 若不指定编码, 则平台默认
     **/
    public void transferByteToChar(String sourceFile, String charsetName) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), charsetName));
        StringBuffer buffer = new StringBuffer();
        char[] data = new char[2];
        while (reader.read(data, 0, data.length) != -1) {
            buffer.append(data);
        }
        log.info("read content by charset {}, result is {}", charsetName, buffer);
    }
}
