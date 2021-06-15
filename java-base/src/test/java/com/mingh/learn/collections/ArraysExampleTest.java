package com.mingh.learn.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName ArraysExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/15 22:45
 * @Description 观察数组操作类中的一些方法
 */
@DisplayName("观察数组操作类中的一些方法")
public class ArraysExampleTest {

    @InjectMocks
    private ArraysExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("观察数组填充")
    public void testFill() {
        ArraysExample.Person p = ArraysExample.Person.builder().name("张三").age(22).build();
        ArraysExample.Person[] pArray = example.fill(p);
        assertEquals(3, pArray.length);
        assertEquals(p, pArray[0]);
        assertEquals(p, pArray[1]);
        assertEquals(p, pArray[2]);
    }

    @Test
    @DisplayName("观察自定义对象的数组比较")
    public void testEquals() {
        ArraysExample.Person[] personArray = {ArraysExample.Person.builder().name("张三").age(22).build()};
        ArraysExample.Person[] pArray = {ArraysExample.Person.builder().name("张三").age(28).build()};
        boolean isPersonSame = example.equals(personArray);
        boolean isPSame = example.equals(pArray);
        assertTrue(isPersonSame);
        assertFalse(isPSame);
    }

    @Test
    @DisplayName("观察下二分查找方法")
    public void testBinarySearch() {
        ArraysExample.Person liP = ArraysExample.Person.builder().name("李四").age(28).build();
        ArraysExample.Person liuP = ArraysExample.Person.builder().name("刘六").age(22).build();
        int personLiIndex = example.binarySearch(liP);
        int personLiuIndex = example.binarySearch(liuP);
        assertEquals(personLiIndex, 1);
        assertTrue(personLiuIndex < 0);
    }

    @Test
    @DisplayName("观察下 toString 方法")
    public void testArrayToString() {
        example.arrayToString();
    }
}
