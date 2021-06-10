package com.mingh.learn.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName SetExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/11 0:26
 * @Version 1.0
 * @Description Set 集合相关方法测试
 */
@DisplayName("Set 集合相关方法测试")
public class SetExampleTest {

    @InjectMocks
    private SetExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("TreeSet 观察自定义对象的排序和重复定义")
    public void testDuplicateAndSort() {
        example.duplicateAndSort();
    }

    @Test
    @DisplayName("TreeSet 保存数据观察")
    public void testExportTreeSet() {
        example.exportTreeSet();
    }

    @Test
    @DisplayName("HashSet 保存数据观察")
    public void testExportHashSet() {
        example.exportHashSet();
    }
}
