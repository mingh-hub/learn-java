package com.mingh.learn.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Objects;

/**
 * @ClassName InputStreamExample
 * @Author Hai.Ming
 * @Date 2021/5/31 18:14
 * @Description 字节输入流
 *      Java 中的流:
 *          我理解的流是个抽象的概念, 是对输入输出方式的抽象。以文件为终端示例, 相对程序而言, 输入流就是程序将外部文件读入, 输出流就是程序将读入的文件再输出。
 *          程序中的所有数据都是以流的形式进行传输或保存的。
 *      字节流:
 *          数据传输过程中以字节为单位进行传输的流。可分为字节输入流(InputStream) 和 字节输出流(OutputStream)
 *      字符流:
 *          1. 数据传输过程中以字符(1个字符占2个字节)为单位进行传输的流。可分为字符输入流(Reader) 和 字符输出流(Writer)
 *          2. 在使用字符流输出的时候, 所有的内容实际上只是输出到了缓冲区(内存), 在使用 close() 方法时, 会将缓冲区的数据进行输出, 如果没有关闭, 那么就将无法输出,
 *              此时可以利用 flush() 进行强制刷新
 *      使用:
 *          80%的业务场景都会用到字节流, 如果是在输出字符串的场景下, 使用 Writer 则更为便捷
 *      区别:
 *          1. 字节流和字符流就好比是数据库中的 BLOB 和 CLOB 的区别, BLOB 保存二进制数据(电影, 图片, 文字, 字节数据), CLOB 保存大文本数据(字符数据)。
 *          2. 在输出的时候, 字节流没有使用缓冲区, 而字符流使用到了缓冲区
 *          3. 如果处理中文使用字符流, 其它的任何数据都使用字节流
 *      联系:
 *          通过任何终端(网络, 文件)读取或者输出的数据都一定是字节数据, 字符是经过内存处理后的数据。
 *          字符输入: 字节(磁盘) 自动转换为 字符(内存)
 *          字符输出: 字符(内存) 自动转换为 字节(磁盘)
 *
 */
@Slf4j
public class InputStreamExample {

    /**
     * @MethodName copy
     * @Author Hai.Ming
     * @Date 2021/5/31 18:36
     * @Description 利用字节流实现文件复制
     **/
    public boolean copy(String sourcePath, String targetPath) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(sourcePath);
            os = new FileOutputStream(targetPath);
            byte[] data = new byte[2048];
            int len;
            while ((len = is.read(data)) != -1) {
                os.write(data, 0, len);
                if (data.length != len) {
                    log.info("最后一次读取字节长度: {}", len);
                }
            }
            log.info("文件复制完成, 地址为: {}", targetPath);
        } catch (FileNotFoundException e) {
            log.error("源文件或者目录不存在", e);
            return false;
        } catch (IOException e) {
            log.error("流关闭失败", e);
            return false;
        } finally {
            try {
                if (Objects.nonNull(is)) {
                    is.close();
                }
                if (Objects.nonNull(os)) {
                    os.close();
                }
            } catch (IOException e) {
                log.error("流关闭失败", e);
            }
        }
        return true;
    }
}
