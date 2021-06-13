package com.mingh.learn.reflect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName ClassExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/13 22:45
 * @Description Class
 */
@DisplayName("观察 Class 类的方法")
public class ClassExampleTest {

    @InjectMocks
    private ClassExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试通过反射实例化对象")
    public void testInstanceObj() throws Exception {
        example.instanceObj();
    }

    @Test
    @DisplayName("测试 Class 实例化的几个方法")
    public void testInstanceClassObj() throws ClassNotFoundException {
        example.instanceClassObj();
    }
}
