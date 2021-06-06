package com.mingh.learn.io;

import com.mingh.learn.common.enums.ResultEnum;
import com.mingh.learn.common.exception.BusinessRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * @ClassName FileExample
 * @Author Hai.Ming
 * @Date 2021/5/30 17:50
 * @Description java.io.File相关操作
 */
@Slf4j
public class FileExample {
    // 内存流: 什么是内存流? 内存流的使用场景是什么?
    //
    // 文件流的操作特点是需要以文件为操作终端, 如果在开发中不需要产生文件但依然需要进行 IO 操作(如网络传输将文件放到内存), 这个时候可以考虑使用内存流

    /**
     * @Author: Hai.Ming
     * @Date: 2021/6/6 10:22
     * @Description: 文件拷贝: 如果想要实现文件的拷贝操作, 可以有如下两种思路
     * 思路一.
     *      构建一个数组, 将需要拷贝的内容读取到数组之中, 而后一次性输出到目标文件
     * 思路二.
     *      采用边读边写的方式进行拷贝
     * 问题:
     *      如果采用思路一, 文件大小应控制在 5M 以内, 如果文件量一大, 内存会占满, 会抛出 OOM 异常
     */
    public void copy(String sourcePath, String targetPath) throws Exception {
        // 判断
        if (StringUtils.isBlank(sourcePath) || StringUtils.isBlank(targetPath)) {
            throw new BusinessRuntimeException(ResultEnum.PARAMS_IS_MISSING);
        }
        // 判断源文件是否存在
        File sourceFile = new File(sourcePath);
        if (!sourceFile.exists()) {
            throw new BusinessRuntimeException(ResultEnum.FILE_NOT_FOUND);
        }
        // 判断目标文件父目录是否存在, 如果不存在则创建
        File targetFile = new File(targetPath);
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        // 拷贝
        this.copyByBufferedStreamWithMoreBytes(sourcePath, targetPath);
    }

    /**
     * @MethodName copy
     * @Author Hai.Ming
     * @Date 2021/6/5 11:07 上午
     * @Description 文件复制(测试案例一)
     *                      (测试目标为 51.7M 文件)
     *                      测试案例一: 通过 InputStream 和 OutputStream 复制文件并进行单个字节读取, 测试消耗时间
     *                      测试案例二: 通过 InputStream 和 OutputStream 复制文件并进行 1024*2 字节读取, 测试消耗时间
     *                      测试案例三: 通过 BufferedInputStream 和 BufferedOutputStream 复制文件并进行单个字节读取, 测试消耗时间
     *                      测试案例三: 通过 BufferedInputStream 和 BufferedOutputStream 复制文件并进行 1024*2 字节读取, 测试消耗时间
     **/
    public void copyByStreamWithOneByte(String sourcePath, String targetPath) throws Exception{
        // 判断输出路径是否存在
        long startTime = System.currentTimeMillis();
        File targetFile = new File(targetPath);
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        // 读取文件
        InputStream is = new FileInputStream(sourcePath);
        OutputStream os = new FileOutputStream(targetFile);
        int len;
        while ((len = is.read()) != -1) {
            os.write(len);
        }
        is.close();
        os.close();
        long endTime = System.currentTimeMillis();
        log.info("通过 InputStream 和 OutputStream 复制文件并进行单个字节读取, 消耗时间 {} ms", endTime - startTime);
    }

    /**
     * @MethodName copyByStreamWithMoreBytes
     * @Author Hai.Ming
     * @Date 2021/6/5 11:23 上午
     * @Description 文件复制(测试案例二)
     **/
    public void copyByStreamWithMoreBytes(String sourcePath, String targetPath) throws Exception{
        // 判断输出路径是否存在
        long startTime = System.currentTimeMillis();
        File targetFile = new File(targetPath);
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        // 读取文件
        InputStream is = new FileInputStream(sourcePath);
        OutputStream os = new FileOutputStream(targetFile);
        int len;
        byte[] data = new byte[1024 * 2];
        while ((len = is.read(data)) != -1) {
            os.write(data, 0, len);
        }
        is.close();
        os.close();
        long endTime = System.currentTimeMillis();
        log.info("通过 InputStream 和 OutputStream 复制文件并进行 1024*2 字节读取, 消耗时间 {} ms", endTime - startTime);
    }

    /**
     * @MethodName copyByBufferedStreamWithOneByte
     * @Author Hai.Ming
     * @Date 2021/6/5 11:27 上午
     * @Description 文件复制(测试案例三)
     **/
    public void copyByBufferedStreamWithOneByte(String sourcePath, String targetPath) throws Exception{
        // 判断输出路径是否存在
        long startTime = System.currentTimeMillis();
        File targetFile = new File(targetPath);
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        // 通过缓冲字节流进行文件复制操作
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));
        int len;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }
        bos.flush();
        bos.close();
        bis.close();
        long endTime = System.currentTimeMillis();
        log.info("通过 BufferedInputStream 和 BufferedOutputStream 复制文件并进行单个字节读取, 消耗时间 {} ms", endTime - startTime);
    }

    /**
     * @MethodName copyByBufferedStreamWithMoreBytes
     * @Author Hai.Ming
     * @Date 2021/6/5 11:32 上午
     * @Description 文件复制(测试案例四)
     **/
    public void copyByBufferedStreamWithMoreBytes(String sourcePath, String targetPath) throws Exception{
        // 判断输出路径是否存在
        long startTime = System.currentTimeMillis();
        File targetFile = new File(targetPath);
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        // 通过缓冲字节流进行文件复制操作
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));
        int len;
        byte[] data = new byte[1024*2];
        while ((len = bis.read(data)) != -1) {
            bos.write(data, 0, len);
        }
        bos.flush();
        bos.close();
        bis.close();
        long endTime = System.currentTimeMillis();
        log.info("通过 BufferedInputStream 和 BufferedOutputStream 复制文件并进行 1024*2 字节读取, 消耗时间 {} ms", endTime - startTime);
    }

    /**
     * @MethodName listAllFilesWithFilter
     * @Author Hai.Ming
     * @Date 2021/5/30 23:24
     * @Description 根据指定 filePath 列出该路径下指定后缀的文件
     **/
    public void listAllFilesWithFilter(String filePath, String suffix) {
        Objects.requireNonNull(filePath, suffix);
        File[] files = new File(filePath).listFiles(file -> file.exists() && file.isFile() && StringUtils.endsWith(file.getName(), suffix));
        assert files != null;
        Arrays.stream(files).forEach(file -> log.info("文件: {}", file.getAbsolutePath()));
    }

    /**
     * @MethodName listAllFiles
     * @Author Hai.Ming
     * @Date 2021/5/30 22:23
     * @Description 根据指定 filePath 列出其下所有 file 文件
     **/
    public void listAllFiles(String filePath) {
        Objects.requireNonNull(filePath);
        File[] files = new File(filePath).listFiles();
        if (Objects.isNull(files)) {
            return;
        }
        Arrays.stream(files).forEach(file -> {
            if (file.exists() && file.isFile()) {
                log.info("文件: {}", file.getAbsolutePath());
            } else {
                listAllFiles(file.getPath());
            }
        });
    }

    /**
     * @MethodName createFile
     * @Author Hai.Ming
     * @Date 2021/5/30 18:00
     * @Description 创建文件或目录
     **/
    public void createFile(String filePath) {
        if (StringUtils.isBlank(filePath)) {
            throw new BusinessRuntimeException(ResultEnum.PARAMS_IS_MISSING);
        }
        File file = new File(filePath);
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            log.info("是否为目录: {}", file.isDirectory());
            log.info("是否为文件: {}", file.isFile());
            file.createNewFile();
        } catch (IOException e) {
            log.error(ResultEnum.FILE_CREATE_FAILURE.getMsg(), e);
        }
    }
}
