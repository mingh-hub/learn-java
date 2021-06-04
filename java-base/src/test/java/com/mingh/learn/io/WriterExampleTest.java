package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.Test;

/**
 * @ClassName WriterExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/1 20:29
 * @Description test case for WriterLearn
 */
public class WriterExampleTest {

    @Test
    public void testOutString() {
        String filePath = CommonConstants.TEST_PATH_DEFAULT;
        String content = "测试利用 FileWriter 输出字符串";
        WriterExample learn = new WriterExample();
        learn.outString(filePath, content);
    }
}
