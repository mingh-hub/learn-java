package com.mingh.learn.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName ListIteratorExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/13 00:52
 * @Description java.util.ListIterator
 */
@DisplayName("ListIterator 相关方法测试")
public class ListIteratorExampleTest {

    @InjectMocks
    private ListIteratorExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("双向迭代测试")
    public void testBothWayLoop() {
        example.bothWayLoop();
    }
}
