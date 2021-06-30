package com.mingh.learn.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName CollectionsExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/13 15:35
 * @Description 观察下集合工具类中的某些方法
 */
@DisplayName("观察下集合工具类中的某些方法")
public class CollectionsExampleTest {

    @InjectMocks
    private CollectionsExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("二分查找")
    public void testBinarySearch() {
        example.binarySearch();
    }

    @Test
    @DisplayName("元素反转")
    public void testReverse() {
        example.reverse();
    }

    @Test
    @DisplayName("添加元素")
    public void testAddAll() {
        example.addAll();
    }
}
