package com.mingh.learn.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName MapExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/13 13:19
 * @Description test java.util.Map
 */
@DisplayName("测试 Map 相关方法操作")
public class MapExampleTest {

    @InjectMocks
    private MapExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试利用自定义的类当做 Map 的 key")
    public void testUseSelfDefineObjectAsKey() {
        example.useSelfDefineObjectAsKey();
    }

    @Test
    @DisplayName("测试利用 forEach 实现 Map 的迭代输出")
    public void testLoopOutputWithForEach() {
        example.loopOutputWithForEach();
    }

    @Test
    @DisplayName("测试利用 Iterator 实现 Map 的迭代输出")
    public void testLoopOutputWithIterator() {
        example.loopOutputWithIterator();
    }

    @Test
    @DisplayName("测试 TreeMap 相关方法实现")
    public void testTreeMapOperation() {
        example.treeMapOperation();
    }

    @Test
    @DisplayName("测试 Hashtable 相关方法实现")
    public void testHashtableOperation() {
        example.hashtableOperation();
    }

    @Test
    @DisplayName("测试 HashMap 相关方法实现")
    public void testHashMapOperation() {
        example.hashMapOperation();
    }
}
