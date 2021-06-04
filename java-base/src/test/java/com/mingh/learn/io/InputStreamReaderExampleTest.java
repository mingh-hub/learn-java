package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.Test;

/**
 * @ClassName InputStreamReaderExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/4 8:38 下午
 * @Description test InputStreamReaderExample
 */
public class InputStreamReaderExampleTest {

    @Test
    public void testTransferByteToChar() throws Exception {
        InputStreamReaderExample example = new InputStreamReaderExample();
        example.transferByteToChar(CommonConstants.TEST_PATH_DEFAULT, "GBK");
    }
}
