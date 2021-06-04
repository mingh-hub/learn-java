package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.Test;

/**
 * @ClassName ReaderExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/1 21:10
 * @Description test case for ReaderLearn
 */
public class ReaderExampleTest {

    @Test
    public void testRead() {
        String filePath = CommonConstants.TEST_PATH_DEFAULT;
        ReaderExample learn = new ReaderExample();
        learn.read(filePath);
    }
}
