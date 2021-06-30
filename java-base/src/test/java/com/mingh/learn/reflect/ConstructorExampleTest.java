package com.mingh.learn.reflect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName ConstructorExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/14 23:45
 * @Description java.lang.reflect.Constructor
 */
@DisplayName("测试构造器相关方法")
public class ConstructorExampleTest {

    @InjectMocks
    private ConstructorExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试通过反射实例化对象-有参")
    public void testInstanceObjUseConstructorWithParams() throws Exception {
        example.instanceObjUseConstructorWithParams();
    }

    @Test
    @DisplayName("测试通过反射实例化对象-无参")
    public void testInstanceObjUseConstructorWithoutParams() throws Exception {
        example.instanceObjUseConstructorWithoutParams();
    }
}
