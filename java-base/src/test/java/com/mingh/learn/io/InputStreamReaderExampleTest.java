package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName InputStreamReaderExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/4 8:38 下午
 * @Description test InputStreamReaderExample
 */
@DisplayName("转换流方法测试")
public class InputStreamReaderExampleTest {

    @InjectMocks
    private InputStreamReaderExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试将字节输入流转换成字符流输出")
    public void testTransferByteToChar() throws Exception {
        example.transferByteToChar(CommonConstants.TEST_PATH_DEFAULT, "GBK");
    }
}
