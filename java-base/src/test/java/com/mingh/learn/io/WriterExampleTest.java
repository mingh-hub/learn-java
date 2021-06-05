package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName WriterExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/1 20:29
 * @Description test case for WriterLearn
 */
public class WriterExampleTest {

    @InjectMocks
    private WriterExample example;

    private String filePath;

    @BeforeEach
    public void setUp() {
        filePath = CommonConstants.TEST_PATH_DEFAULT;
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试字符输出")
    public void testOutString() {
        String content = "测试利用 FileWriter 输出字符串";
        example.outString(filePath, content);
    }
}
