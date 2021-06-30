package com.mingh.learn.collections;

import com.mingh.learn.beans.Book;
import com.mingh.learn.common.enums.ResultEnum;
import com.mingh.learn.common.exception.BusinessRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Iterator;
import java.util.List;

/**
 * @ClassName IterableExample
 * @Author Hai.Ming
 * @Date 2021/6/9 20:10
 * @Description java.lang.Iterable JDK1.5
 *                      1. 很多类都实现了 Iterable 接口, 如 Collection, List, Set
 *                      2. Iterator<T> iterator(): 调用此方法会返回一个迭代器-Iterator, 迭代器内的核心方法 hasNext() & next(), 循环遍历使用
 *                      3. default void forEach(Consumer<? super T> action): JDK1.8 提供的默认方法, 入参接收消费型函数式接口(Consumer), 循环遍历使用
 */
@Slf4j
public class IterableExample {

    /**
     * @MethodName loop
     * @Author Hai.Ming
     * @Date 2021/6/9 20:57
     * @Description 迭代器循环
     **/
    public void loop(List<Book> books) {
        if (CollectionUtils.isEmpty(books)) {
            throw new BusinessRuntimeException(ResultEnum.PARAMS_IS_MISSING);
        }
        Iterator<Book> bookIterator = books.listIterator();
        while (bookIterator.hasNext()) {
            log.info("Book info: {}", bookIterator.next());
        }
    }
}
