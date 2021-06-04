package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.Test;

/**
 * @ClassName OutputStreamExampleTest
 * @Author Hai.Ming
 * @Date 2021/5/31 20:39
 * @Description test OutputStream
 */
public class OutputStreamExampleTest {

    /**
     * @MethodName testOutputWithAppend
     * @Author Hai.Ming
     * @Date 2021/5/31 20:43
     * @Description 测试利用 OutputStream 进行追加输出
     **/
    @Test
    public void testOutputWithAppend() {
        String filePath = CommonConstants.TEST_PATH_DEFAULT;
        OutputStreamExample learn = new OutputStreamExample();
        learn.outputWithAppend(filePath);
    }

    /**
     * @MethodName testOutputWithOverride
     * @Author Hai.Ming
     * @Date 2021/5/31 20:40
     * @Description 测试利用 OutputStream 进行覆盖输出
     **/
    @Test
    public void testOutputWithOverride() {
        String filePath = CommonConstants.TEST_PATH_DEFAULT;
        OutputStreamExample learn = new OutputStreamExample();
        learn.outputWithOverride(filePath);
    }
}
