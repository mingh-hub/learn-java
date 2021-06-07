package com.mingh.learn.socket;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @ClassName ServerSocketExample
 * @Author Hai.Ming
 * @Date 2021/6/7 18:30
 * @Description Socket server
 */
public class ServerSocketExample {

    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(9999);
        System.out.println("接受客户请求信息...");
        Socket client = server.accept();
        Scanner scan = new Scanner(client.getInputStream());
        PrintStream ps = new PrintStream(client.getOutputStream());
        scan.useDelimiter("\n");
        boolean flag = true;
        while (flag) {
            if (scan.hasNext()) {
                if ("bye".equals(scan.next().trim())) {
                    flag = false;
                } else {
                    String message = new StringJoiner("ECHO").add(": ").add(scan.next().trim()).toString();
                    ps.println(message);
                }
            }
        }
        ps.close();
        client.close();
    }
}
