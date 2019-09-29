package com.beofy.block.io;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {

    private final int PORT = 7777;

    public static void main(String[] args) throws IOException {
        new Server().start();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("服务启动,端口："+PORT);
        Socket socket = serverSocket.accept();
        System.out.println("有客户端连接......");

        //接受消息
        InputStream inputStream = socket.getInputStream();
        byte[] temp = new byte[2048];
        int length;
        while ((length = inputStream.read(temp)) != -1) {
            String s = new String(temp, 0, length, StandardCharsets.UTF_8);
            System.out.print(s);
        }
        inputStream.close();

        //返回消息
//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("你好".getBytes(StandardCharsets.UTF_8));
//        outputStream.flush();
//        outputStream.close();


        socket.close();
        serverSocket.close();
    }


}
