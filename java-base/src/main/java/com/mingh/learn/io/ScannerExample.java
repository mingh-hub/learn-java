package com.mingh.learn.io;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Scanner;

/**
 * @ClassName ScannerExample
 * @Author Hai.Ming
 * @Date 2021/6/6 22:50
 * @Version 1.0
 * @Description java.util.Scanner ★★★★★
 *                        构造方法:
 *                          public Scanner(InputStream source)
 *                          public Scanner(File source) throws FileNotFoundException
 *
 */
@Slf4j
public class ScannerExample {

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/6 23:27
     * @Description:  利用 java.util.Scanner 实现文件读取
     */
    public void scanFile(String sourcePath)throws Exception {
        Scanner scan = new Scanner(new File(sourcePath));
        // 设置换行为分隔符
        scan.useDelimiter("\n");
        while (scan.hasNext()) {
            log.info(scan.next());
        }
        scan.close();
    }

    public static void main(String[] args) {
//        enterString();
//        entInt();
        entDate();
    }
    private static void entDate() {
        String dateRegex = "\\d{4}-\\d{2}-\\d{2}";
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入生日: ");
        if (scan.hasNext(dateRegex)) {
            System.out.println("输入的生日为: " + scan.next(dateRegex));
        } else {
            System.out.println("输入的不是生日");
        }
        scan.close();
    }

    private static void entInt() {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        System.out.print("请输入年龄: ");
        if (scan.hasNextInt()) {
            System.out.println("输入的年龄为: " + scan.nextInt());
        } else {
            System.out.println("输入的不是数字");
        }
        scan.close();
    }

    private static void enterString() {
        Scanner scan = new Scanner(System.in);
        // Scanner 默认将空格和换行作为读取分隔符, 如果输入的是 "你好 世界", 只会输出 "你好"
        // 此时需要设置分割符为换行
        scan.useDelimiter("\n");
        System.out.print("请输入信息: ");
        System.out.println("输入的信息为: " + scan.next());
        scan.close();
    }
}
