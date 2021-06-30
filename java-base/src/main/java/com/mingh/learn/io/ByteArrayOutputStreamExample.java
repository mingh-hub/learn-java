package com.mingh.learn.io;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @ClassName ByteArrayOutputStreamExample
 * @Author Hai.Ming
 * @Date 2021/6/6 14:46
 * @Version 1.0
 * @Description 字节内存输出流
 */
@Slf4j
public class ByteArrayOutputStreamExample {

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/6 14:50
     * @Description:  文件合并
     */
    public void mergeFile(@NonNull String[] sourceFilePaths, @NonNull String targetFilePath) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 0; i < sourceFilePaths.length; i++) {
            InputStream is = new BufferedInputStream(new FileInputStream(sourceFilePaths[i]));
            byte[] data = new byte[1024 * 2];
            int len;
            while ((len = is.read(data)) != -1) {
                baos.write(data, 0, len);
            }
            is.close();
        }
        OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(targetFilePath)));
        os.write(baos.toString().toUpperCase().getBytes());
        os.close();
        baos.close();
    }

}
