package com.mingh.learn.reflect;

import com.mingh.learn.reflect.bean.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName FieldExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/15 00:10
 * @Description java.lang.reflect.Field
 */
@DisplayName("观察 Field 内的方法")
public class FieldExampleTest {

    @InjectMocks
    private FieldExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试给属性赋值")
    public void testSetField() throws Exception {
        String name = "张三";
        int age = 22;
        Person p = example.setField(name, age);
        assertEquals(name, p.getName());
        assertEquals(age, p.getAge());
    }
}
