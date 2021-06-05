package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName OutputStreamWriterExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/2 20:34
 * @Description test OutputStreamWriterLearn
 */
public class OutputStreamWriterExampleTest {

    @InjectMocks
    private OutputStreamWriterExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("将字符转成字节输出")
    public void testWriteCharToFile() throws Exception {
        String targetFile = CommonConstants.TEST_PATH_DEFAULT;
        String content = "字符转成字节输出";
        String charsetName = "GBK";
        example.transferCharToByte(targetFile, content, charsetName);
    }
}
