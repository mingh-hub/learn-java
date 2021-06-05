package com.mingh.learn.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName InputStreamExampleTest
 * @Author Hai.Ming
 * @Date 2021/5/31 20:49
 * @Description test InputStreamLearn
 */
@DisplayName("字节输入流测试")
public class InputStreamExampleTest {

    @InjectMocks
    private InputStreamExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * @MethodName testCopy
     * @Author Hai.Ming
     * @Date 2021/5/31 20:50
     * @Description 测试利用字节流进行文件复制
     **/
    @Test
    @DisplayName("测试利用字节流进行文件复制")
    public void testCopy() {
        String sourcePath = "/Users/user/Pictures/head.jpg";
        String targetPath = "/Users/user/Desktop/head1.jpg";
        example.copy(sourcePath, targetPath);
    }
}