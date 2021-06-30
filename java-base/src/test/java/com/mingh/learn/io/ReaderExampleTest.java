package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName ReaderExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/1 21:10
 * @Description test case for ReaderLearn
 */
@DisplayName("字符输入流测试")
public class ReaderExampleTest {

    @InjectMocks
    private ReaderExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("通过字符流读入源文件内容")
    public void testRead() {
        example.read(CommonConstants.TEST_PATH_DEFAULT);
    }
}
