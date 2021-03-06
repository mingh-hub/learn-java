package com.mingh.learn.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName StackExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/13 16:24
 * @Description 观察 Stack 的相关方法
 */
@DisplayName("观察 Stack 的相关方法")
public class StackExampleTest {

    @InjectMocks
    private StackExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("利用 Stack 的 LIFO 实现字符串反转")
    public void testReverse() {
        String str = "abcde";
        String reverseStr = example.reverse(str);
        assertEquals(reverseStr, new StringBuffer(str).reverse().toString());
    }

    @Test
    @DisplayName("压栈和出栈")
    public void testPushThenPop() {
        example.pushThenPop();
    }
}
