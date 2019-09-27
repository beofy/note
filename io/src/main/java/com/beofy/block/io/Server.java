package com.beofy.block.io;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Server {

    public static void main(String[] args) {
        new Server().start();
    }

    public void start() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("服务启动........,监听端口：7777");
            while (true) {
                accept = serverSocket.accept();//阻塞
                System.out.println("有连接访问...");
                inputStream = accept.getInputStream();
                outputStream = accept.getOutputStream();

//                while (true) {
//                    byte[] temp = new byte[2048];
//                    int data = inputStream.read(temp);
//                    if (data != -1 && data < temp.length) {
//                        String s = new String(temp, 0, data, StandardCharsets.UTF_8);
//                        System.out.println(s);
//                    } else {
//                        break;
//                    }
//                }

                String header = "HTTP /1.1 200 OK\n" +
                        "Date: " + new Date().toString() + "\n" +
                        "Content-Type: text/html;charset=utf-8\n" +
                        "Content-Length: 122\n" +
                        "\r\n";
                String html = "<!DOCTYPE html><html><head><meta><title>该网页无法访问</title></head><body><h1>hello world</h1></body></html>";
                String response = header + html;
                outputStream.write(response.getBytes());

                System.out.println(response);
                //关闭流
                outputStream.flush();
                inputStream.close();
                outputStream.close();
                //accept.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
                if (accept != null) accept.close();
                if (inputStream != null) inputStream.close();
                if (outputStream != null) outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
