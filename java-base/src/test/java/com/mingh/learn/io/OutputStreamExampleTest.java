package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName OutputStreamExampleTest
 * @Author Hai.Ming
 * @Date 2021/5/31 20:39
 * @Description test OutputStream
 */
@DisplayName("字节输出流相关方法测试")
public class OutputStreamExampleTest {

    @InjectMocks
    private OutputStreamExample example;

    private String filePath;

    @BeforeEach
    public void setUp() {
        filePath = CommonConstants.TEST_PATH_DEFAULT;
        MockitoAnnotations.openMocks(this);
    }

    /**
     * @MethodName testOutputWithAppend
     * @Author Hai.Ming
     * @Date 2021/5/31 20:43
     * @Description 测试利用 OutputStream 进行追加输出
     **/
    @Test
    @DisplayName("追加输出")
    public void testOutputWithAppend() {
        example.outputWithAppend(filePath);
    }

    /**
     * @MethodName testOutputWithOverride
     * @Author Hai.Ming
     * @Date 2021/5/31 20:40
     * @Description 测试利用 OutputStream 进行覆盖输出
     **/
    @Test
    @DisplayName("覆盖输出")
    public void testOutputWithOverride() {
        example.outputWithOverride(filePath);
    }
}
