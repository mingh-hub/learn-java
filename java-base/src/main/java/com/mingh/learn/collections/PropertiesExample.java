package com.mingh.learn.collections;

import com.mingh.learn.common.constant.CommonConstants;

import java.io.*;
import java.util.Properties;

/**
 * @ClassName PropertiesExample
 * @Author Hai.Ming
 * @Date 2021/6/13 16:41
 * @Description java.util.Properties ★★★ JDK1.0
 *                      1. Properties 是专门负责属性信息操作的类, 是 Hashtable 的子类
 *                      2. Properties 能存放的数据只能是字符串, 使用其本身提供的方法
 *                      3. 资源文件中的中文必须经过编码转换
 */
public class PropertiesExample {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 17:20
     * @Description 从源文件读取内容
     **/
    public void load(String sourceFile) throws Exception {
        Properties properties = new Properties();
        InputStream is = new BufferedInputStream(new FileInputStream(sourceFile));
        properties.load(is);
        System.out.println(properties);
        System.out.println(properties.getProperty("username"));
        is.close();
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 17:15
     * @Description 设置属性信息到对应的资源文件
     **/
    public void store(String targetFile) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("username", CommonConstants.DB_NAME);
        properties.setProperty("password", CommonConstants.DB_PASSWORD);
        properties.setProperty("driver", CommonConstants.DB_DRIVER);

        OutputStream os = new FileOutputStream(targetFile);
        PrintStream ps = new PrintStream(os);
        properties.store(ps,"No comment");

        ps.close();
        os.close();
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 17:02
     * @Description 设置属性信息到对应的资源文件
     **/
    public void list(String fileName) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("username", CommonConstants.DB_NAME);
        properties.setProperty("password", CommonConstants.DB_PASSWORD);
        properties.setProperty("driver", CommonConstants.DB_DRIVER);

        OutputStream os = new FileOutputStream(fileName);
        PrintStream ps = new PrintStream(os);
        properties.list(ps);

        ps.close();
        os.close();
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 16:55
     * @Description 文件属性信息操作
     **/
    public void operateProperties() {
        Properties properties = new Properties();
        properties.setProperty("username", CommonConstants.DB_NAME);
        properties.setProperty("password", CommonConstants.DB_PASSWORD);
        properties.setProperty("driver", CommonConstants.DB_DRIVER);
        System.out.println(properties);
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("url", "未获取到 url"));
    }
}
