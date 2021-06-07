package com.mingh.learn.socket;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName SocketExample
 * @Author Hai.Ming
 * @Date 2021/6/7 18:29
 * @Description Socket client
 */
public class SocketExample {

    public static void main(String[] args) throws Exception{
        Socket client = new Socket("localhost", 9999);
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        Scanner in = new Scanner(client.getInputStream());
        input.useDelimiter("\n");
        in.useDelimiter("\n");
        PrintStream ps = new PrintStream(client.getOutputStream());
        while (flag) {
            System.out.print("请输入消息:");
            if (input.hasNext()) {
                String message = input.next().trim();
                ps.println(message);
                if (in.hasNext()) {
                    System.out.println(in.next().trim());
                }
                if ("bye".equals(message)) {
                    System.out.println("game over");
                    flag = false;
                }
            }
        }
        ps.close();
        client.close();
    }
}
