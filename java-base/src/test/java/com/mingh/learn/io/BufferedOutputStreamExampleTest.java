package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName BufferedOutputStreamExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/5 0:18
 * @Version 1.0
 * @Description test for BufferedOutputStream
 */
@DisplayName("测试缓冲字节输出流")
public class BufferedOutputStreamExampleTest {

    @InjectMocks
    private BufferedOutputStreamExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("通过缓冲字节输出流将数据写入文件")
    public void testWrite() throws Exception {
        String content = "通过缓冲输出字节流向目标文件写数据";
        example.write(CommonConstants.TEST_PATH_DEFAULT, content);
    }
}
