package com.mingh.learn.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName ByteArrayOutputStreamExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/6 14:58
 * @Version 1.0
 * @Description 字节内存输出流
 */
@DisplayName("字节内存输出流")
public class ByteArrayOutputStreamExampleTest {

    @InjectMocks
    private ByteArrayOutputStreamExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试文件合并")
    public void testMergeFile() throws Exception {
        String[] sourceFilePaths = {"C:\\Users\\Administrator\\Desktop\\test1.txt", "C:\\Users\\Administrator\\Desktop\\test2.txt"};
        String targetFilePath = "C:\\Users\\Administrator\\Desktop\\test.txt";
        example.mergeFile(sourceFilePaths, targetFilePath);
    }
}
