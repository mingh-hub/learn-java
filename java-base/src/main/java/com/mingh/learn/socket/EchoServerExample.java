package com.mingh.learn.socket;

import org.apache.commons.lang3.StringUtils;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName EchoServerExample
 * @Author Hai.Ming
 * @Date 2021/6/7 18:30
 * @Description Socket server
 */
public class EchoServerExample {

    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(8888);
        System.out.println("准备接受客户端请求信息...");
        Socket client = server.accept();
        // 获取客户端地址
        String clientAddress = client.getInetAddress().getHostAddress();
        int port = client.getPort();
        // 获取客户端输入流
        Scanner scan = new Scanner(client.getInputStream());
        // 服务端响应信息返回客户端
        PrintStream ps = new PrintStream(client.getOutputStream());
        // 设置分隔符, 打印流默认空格和回车作为分隔符
        scan.useDelimiter("\n");
        boolean flag = true;
        while (flag) {
            if (scan.hasNext()) {
                String message = scan.next().trim();
                if (StringUtils.equals(message, "88")) {
                    flag = false;
                    ps.println(String.format("请求客户端: [%s:%s] 已断开连接", clientAddress, port));
                } else {
                    ps.println(StringUtils.join("ECHO", ": ", message));
                }
            }
        }
        ps.close();
        client.close();
    }
}
