package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.Test;

/**
 * @ClassName BufferedOutputStreamExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/5 0:18
 * @Version 1.0
 * @Description test for BufferedOutputStream
 */
public class BufferedOutputStreamExampleTest {

    @Test
    public void testWrite() throws Exception {
        String content = "通过缓冲输出字节流向目标文件写数据";
        BufferedOutputStreamExample example = new BufferedOutputStreamExample();
        example.write(CommonConstants.TEST_PATH_DEFAULT, content);
    }
}
