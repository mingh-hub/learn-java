package com.mingh.learn.utils;

import com.mingh.learn.beans.Book;
import com.mingh.learn.common.enums.CommonEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DataUtils
 * @Author Hai.Ming
 * @Date 2021/6/9 20:42
 * @Description 项目学习中数据准备
 */
public class DataUtils {

    /**
     * @MethodName listBooks
     * @Author Hai.Ming
     * @Date 2021/6/9 20:43
     * @Description 准备集合数据-Book
     **/
    public static List<Book> prepareListBooks() {
        return new ArrayList<Book>() {
            {
                add(CommonEnum.BookType.build(CommonEnum.BookType.ANNA_KARENINA));
                add(CommonEnum.BookType.build(CommonEnum.BookType.BURNING_PAPER));
                add(CommonEnum.BookType.build(CommonEnum.BookType.DREAM_OF_THE_RED_CHAMBER));
                add(CommonEnum.BookType.build(CommonEnum.BookType.EFFECTIVE_JAVA));
                add(CommonEnum.BookType.build(CommonEnum.BookType.FORTRESS_BESIEGED));
                add(CommonEnum.BookType.build(CommonEnum.BookType.GONE_WITH_THE_WIND));
                add(CommonEnum.BookType.build(CommonEnum.BookType.LINUX));
                add(CommonEnum.BookType.build(CommonEnum.BookType.RECORDS_OF_THE_HISTORIAN));
                add(CommonEnum.BookType.build(CommonEnum.BookType.VIRTUAL_MACHINE_JAVA));
            }
        };
    }
}
