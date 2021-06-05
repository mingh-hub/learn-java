package com.mingh.learn.io;

import com.mingh.learn.utils.BusinessUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName FileExampleTest
 * @Author Hai.Ming
 * @Date 2021/5/30 18:10
 * @Description test FileDemo
 */
@Slf4j
@DisplayName("文件操作相关测试")
public class FileExampleTest {

    @InjectMocks
    private FileExample example;

    private String sourcePath;
    private String targetPath;

    @BeforeEach
    public void setUp() {
        sourcePath = "F:\\software\\download\\typora-setup-x64.exe";
        targetPath = "C:\\Users\\Administrator\\Desktop\\typora-setup-x64.exe";
        MockitoAnnotations.openMocks(this);
    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/5 22:39
     * @Description:  目标文件大小 51.7M, 测试小号时间 167 ms
     */
    @Test
    @DisplayName("通过 BufferedInputStream 和 BufferedOutputStream 复制文件并进行 1024*2 字节读取, 测试消耗时间")
    public void testCopyByBufferedStreamWithMoreBytes() throws Exception {
        example.copyByBufferedStreamWithMoreBytes(sourcePath, targetPath);
    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/5 22:28
     * @Description:  目标文件大小 51.7M, 测试小号时间 1768 ms
     */
    @Test
    @DisplayName("通过 BufferedInputStream 和 BufferedOutputStream 复制文件并进行单个字节读取, 测试消耗时间")
    public void testCopyByBufferedStreamWithOneByte() throws Exception {
        example.copyByBufferedStreamWithOneByte(sourcePath, targetPath);
    }

    /**
     * @Author:  Hai.Ming
     * @Date:  2021/6/5 22:21
     * @Description:  目标文件大小 51.7M, 测试小号时间 315 ms
     */
    @Test
    @DisplayName("通过 InputStream 和 OutputStream 复制文件并进行 1024*2 字节读取, 测试消耗时间")
    public void testCopyByStreamWithMoreBytes() throws Exception {
        example.copyByStreamWithMoreBytes(sourcePath, targetPath);
    }

    /**
     * @MethodName testCopyByStreamWithOneByte
     * @Author Hai.Ming
     * @Date 2021/6/5 11:33 上午
     * @Description 目标文件大小 51.7M, 测试小号时间 352712 ms
     **/
    @Test
    @DisplayName("测试通过 InputStream 和 OutputStream 复制文件并进行单个字节读取, 测试消耗时间")
    public void testCopyByStreamWithOneByte() throws Exception {
        example.copyByStreamWithOneByte(sourcePath, targetPath);
    }

    /**
     * @MethodName testListAllFilesBySpecifiedPathnameWithFilter
     * @Author Hai.Ming
     * @Date 2021/5/30 23:16
     * @Description 根据指定 pathname 过滤出所需文件
     **/
    @Test
    public void testListAllFilesBySpecifiedPathnameWithFilter() {
        // 列出 /Users/user/mingh/maven/mvn-repo/com/xhqb/usercenter/usercenter/4.0.0-SNAPSHOT/ 路径下的 pom 文件
        String filePath = "/Users/user/mingh/maven/mvn-repo/com/xhqb/usercenter/usercenter/4.0.0-SNAPSHOT/";
        String suffix = "pom";
        example.listAllFilesWithFilter(filePath, suffix);
    }

    /**
     * @MethodName testListAllFilesBySpecifiedPathname
     * @Author Hai.Ming
     * @Date 2021/5/30 23:03
     * @Description 根据指定目录列出该目录下的所有文件
     **/
    @Test
    public void testListAllFilesBySpecifiedPathname() {
        String filePath = "/Users/user/mingh/maven";
        example.listAllFiles(filePath);
    }

    /**
     * @MethodName testCreateFile
     * @Author Hai.Ming
     * @Date 2021/5/30 18:37
     * @Description 测试创建文件及相关问题说明
     **/
    @Test
    public void testCreateFile() {
        // 问题一: 文件路径的分隔符不要写死, 用 File.separator 替代, 要考虑分隔符的问题, 如 e:\test.txt 中 \t 表示制表符
        // 问题二: 文件的创建会存在延迟操作, 这种延迟操作很多时候是可以忽略掉的, 单也有一点不能忽略, 即刚刚删除了一个文件, 就有可能存在创建不了的情况
        // 问题三: 如果给定的文件目录不存在, 则文件无法创建。解决: 创建前先判断文件父路径是否存在, 不存在则先创建父路径 file.getParentFile().mkdirs()
        String filePath = "/Users/user/mingh/repository/study/helloworld/test.txt";
        example.createFile(BusinessUtils.filePathReplace(filePath));
    }
}
