package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName PrintStreamExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/6 19:38
 * @Version 1.0
 * @Description 字节打印流
 */
@DisplayName("字节打印流方法测试")
public class PrintStreamExampleTest {

    @InjectMocks
    private PrintStreamExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试格式化输出内容到目标文件")
    public void testPrintfToFile() throws Exception {
        String content = "故土在战争中沦陷，大学被占领、被炸毁。一群十八九岁的青年学生，他们匆匆出发，徒步南迁，横穿湘黔滇，最终在昆明高原组建临时大学——由清华、北大、南开联合成立的西南联大。";
        example.printf(content, CommonConstants.TEST_PATH_DEFAULT);
    }

    @Test
    @DisplayName("测试输出内容到目标文件")
    public void testPrintToFile() throws Exception {
        example.print("测试输出内容到控制台", CommonConstants.TEST_PATH_DEFAULT);
    }

    @Test
    @DisplayName("测试输出内容到控制台")
    public void testPrintToClient() throws Exception {
        example.print("测试输出内容到控制台");
    }
}
