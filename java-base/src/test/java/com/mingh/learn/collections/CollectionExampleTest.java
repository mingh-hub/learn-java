package com.mingh.learn.collections;

import com.google.common.collect.Lists;
import com.mingh.learn.beans.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @ClassName CollectionExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/10 0:27
 * @Version 1.0
 * @Description Collection 集合接口方法测试
 */
@DisplayName("Collection 集合接口方法测试")
public class CollectionExampleTest {

    @InjectMocks
    private CollectionExample example;

    private User user;

    @BeforeEach
    public void setUp() {
        user = User.builder().chName("张三").age(22).build();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试 Collection 集合接口的 iterator() 方法")
    public void testIterator() {
        Collection<User> collection = Lists.newArrayList();
        collection.add(user);
        example.iterator(collection);
    }

    @Test
    @DisplayName("测试 Collection 集合接口的 contains 方法")
    public void testRemove() {
        Collection<User> collection = example.remove(user);
        assertTrue(collection.isEmpty());
    }

    @Test
    @DisplayName("测试 Collection 集合接口的 contains 方法")
    public void testContains() {
        boolean result = example.contains(user);
        assertTrue(result);
    }

}
