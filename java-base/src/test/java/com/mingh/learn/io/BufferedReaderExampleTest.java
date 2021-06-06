package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName BufferedReaderExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/6 20:56
 * @Version 1.0
 * @Description 缓冲字符输入流
 */
@DisplayName("缓冲字符输入流方法测试")
public class BufferedReaderExampleTest {

    @InjectMocks
    private BufferedReaderExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试缓冲字符输入流的 readLine() 方法")
    public void testReadLine() throws Exception {
        example.readLine(CommonConstants.TEST_PATH_DEFAULT);
    }
}
