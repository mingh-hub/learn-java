package com.mingh.learn.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName EnumerationExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/13 12:11
 * @Description test Enumeration
 */
@DisplayName("Enumeration 相关方法测试")
public class EnumerationExampleTest {

    @InjectMocks
    private EnumerationExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试循环迭代输出")
    public void testLoop() {
        example.loop();
    }
}
