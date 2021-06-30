package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName BufferedInputStreamExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/5 10:41 上午
 * @Description test BufferedInputStreamExample
 */
@DisplayName("缓冲字节输入流")
public class BufferedInputStreamExampleTest {

    @InjectMocks
    private BufferedInputStreamExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试通过缓冲字节输入流从源文件读入数据")
    public void testRead() throws Exception {
        example.read(CommonConstants.TEST_PATH_DEFAULT);
    }
}
