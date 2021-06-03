package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.Test;

/**
 * @ClassName OutputStreamWriterLearnTest
 * @Author Hai.Ming
 * @Date 2021/6/2 20:34
 * @Description test OutputStreamWriterLearn
 */
public class OutputStreamWriterLearnTest {

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

        OutputStreamWriterLearn learn = new OutputStreamWriterLearn();
        learn.transferCharToByte(targetFile, content);
    }
}
