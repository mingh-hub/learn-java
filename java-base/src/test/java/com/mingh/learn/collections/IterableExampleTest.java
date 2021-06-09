package com.mingh.learn.collections;

import com.mingh.learn.beans.Book;
import com.mingh.learn.utils.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

/**
 * @ClassName IterableExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/9 20:53
 * @Description test for IterableExample
 */
@DisplayName("Iterable 接口相关方法测试")
public class IterableExampleTest {

    @InjectMocks
    private IterableExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试通过迭代器循环")
    public void testLoop() {
        List<Book> books = DataUtils.prepareListBooks();
        example.loop(books);
    }
}
