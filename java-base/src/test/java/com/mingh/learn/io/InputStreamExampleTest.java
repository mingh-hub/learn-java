package com.mingh.learn.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @ClassName InputStreamExampleTest
 * @Author Hai.Ming
 * @Date 2021/5/31 20:49
 * @Description test InputStreamLearn
 */
@DisplayName("test InputStreamLearn")
public class InputStreamExampleTest {

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
        InputStreamExample learn = new InputStreamExample();
        learn.copy(sourcePath, targetPath);
    }
}