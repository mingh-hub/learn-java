package com.mingh.learn.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName IteratorExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/12 19:15
 * @Description test Iterator
 */
@DisplayName("Iterator 接口相关方法测试")
public class IteratorExampleTest {

    @InjectMocks
    private IteratorExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("元素移除")
    public void testRemove() {
        example.remove();
    }

    @Test
    @DisplayName("循环输出")
    public void testLoop() {
        example.loop();
    }
}
