package com.mingh.learn.reflect;

import com.mingh.learn.reflect.bean.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName MethodExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/14 22:33
 * @Description 观察 java.lang.reflect.Method 相关方法
 */
@DisplayName("测试 Method 相关方法")
public class MethodExampleTest {

    @InjectMocks
    private MethodExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("反射调用当前类的私有方法")
    public void testInvokePrivateMethod() throws Exception {
        example.invokePrivateMethod();
    }

    @Test
    @DisplayName("反射获取对象内的方法集合")
    public void testObtainMethods() throws Exception {
        example.obtainMethods();
    }

    @Test
    @DisplayName("通过反射调用方法给对象属性赋值")
    public void testInvokeSetMethod() throws Exception {
        String value = "张三";
        Person p = example.invokeSetMethod("name", value);
        assertEquals(value, p.getName());
    }
}
