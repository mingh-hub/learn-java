package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.Test;

/**
 * @ClassName BufferedInputStreamExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/5 10:41 上午
 * @Description test BufferedInputStreamExample
 */
public class BufferedInputStreamExampleTest {

    @Test
    public void testRead() throws Exception {
        BufferedInputStreamExample example = new BufferedInputStreamExample();
        example.read(CommonConstants.TEST_PATH_DEFAULT);
    }
}
