package com.mingh.learn.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName ListExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/10 23:20
 * @Version 1.0
 * @Description List 相关方法测试
 */
@DisplayName("List 相关方法测试")
public class ListExampleTest {

    @InjectMocks
    private ListExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试通过索引向 List 中添加元素")
    public void testAddWithIndex() {
        example.addWithIndex();
    }
}
