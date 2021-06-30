package com.mingh.learn.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName ByteArrayInputStreamExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/6 14:28
 * @Version 1.0
 * @Description 字节内存流相关操作测试
 */
@DisplayName("字节内存输入流相关操作测试")
public class ByteArrayInputStreamExampleTest {

    @InjectMocks
    private ByteArrayInputStreamExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试将内容输入大写后再保存到内存中")
    public void testWrite() throws Exception {
        String content = "hello world !!!";
        String result = example.write(content);
        assertEquals(result, content.toUpperCase());
    }
}
