package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.Test;

/**
 * @ClassName OutputStreamWriterExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/2 20:34
 * @Description test OutputStreamWriterLearn
 */
public class OutputStreamWriterExampleTest {

    /**
     * @MethodName testWriteCharToFile
     * @Author Hai.Ming
     * @Date 2021/6/2 20:34
     * @Description 字符转成字节输出
     **/
    @Test
    public void testWriteCharToFile() throws Exception {
        String targetFile = CommonConstants.TEST_PATH_DEFAULT;
        String content = "字符转成字节输出";

        OutputStreamWriterExample learn = new OutputStreamWriterExample();
        learn.transferCharToByte(targetFile, content);
    }
}
