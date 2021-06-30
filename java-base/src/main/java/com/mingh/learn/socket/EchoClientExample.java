package com.mingh.learn.socket;

import org.apache.commons.lang3.StringUtils;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName EchoClientExample
 * @Author Hai.Ming
 * @Date 2021/6/7 18:29
 * @Description Socket client
 */
public class EchoClientExample {

    public static void main(String[] args) throws Exception{
        Socket client = new Socket("localhost", 8888);
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        // 服务返回的消息
        Scanner returnMsg = new Scanner(client.getInputStream());
        input.useDelimiter("\n");
        returnMsg.useDelimiter("\n");
        // 向服务端发送消息
        PrintStream out = new PrintStream(client.getOutputStream());
        while (flag) {
            System.out.print("请输入消息:");
            if (input.hasNext()) {
                String message = input.next().trim();
                out.println(message);
                if (returnMsg.hasNext()) {
                    System.out.println(returnMsg.next().trim());
                }
                if (StringUtils.equals(message, "88")) {
                    System.out.println("Game Over");
                    flag = false;
                }
            }
        }
        out.close();
        client.close();
    }
}
