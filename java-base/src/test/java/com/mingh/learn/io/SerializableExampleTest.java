package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName SerializableExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/6 23:55
 * @Version 1.0
 * @Description SerializableExample
 */
@DisplayName("序列化相关方法测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SerializableExampleTest {

    @InjectMocks
    private SerializableExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("序列化")
    public void testSavePerson() throws Exception {
        SerializableExample.Person person = SerializableExample.Person.builder().name("测试").age(12).build();
        example.savePerson(person, CommonConstants.TEST_PATH_DEFAULT);
    }

    @Test
    @Order(2)
    @DisplayName("反序列化")
    public void testGetPerson() throws Exception {
        SerializableExample.Person person = example.getPerson(CommonConstants.TEST_PATH_DEFAULT);
        assertEquals("测试", person.getName());
        assertEquals(null, person.getAge());
    }
}
