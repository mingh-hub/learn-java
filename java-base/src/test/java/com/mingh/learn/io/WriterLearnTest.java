package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.Test;

/**
 * @ClassName WriterLearnTest
 * @Author Hai.Ming
 * @Date 2021/6/1 20:29
 * @Description test case for WriterLearn
 */
public class WriterLearnTest {

    @Test
    public void testOutString() {
        String filePath = CommonConstants.TEST_PATH_DEFAULT;
        String content = "测试利用 FileWriter 输出字符串";
        WriterLearn learn = new WriterLearn();
        learn.outString(filePath, content);
    }
}
