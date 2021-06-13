package com.mingh.learn.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName PropertiesExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/13 16:58
 * @Description 观察 Properties 内的相关操作
 */
@DisplayName("观察 Properties 内的相关操作")
public class PropertiesExampleTest {

    @InjectMocks
    private PropertiesExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("从资源文件加载数据")
    public void testLoad() throws Exception {
        example.load("src/main/resources/jdbc.properties");
    }

    @Test
    @DisplayName("数据加载到资源文件")
    public void testStore() throws Exception {
        example.store("src/main/resources/jdbc.properties");
    }

    @Test
    @DisplayName("数据加载到资源文件")
    public void testList() throws Exception {
        example.list("src/main/resources/jdbc.properties");
    }

    @Test
    @DisplayName("属性操作")
    public void testOperateProperties() {
        example.operateProperties();
    }
}
