package com.beofy.block.io;


import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {

    public static void main(String[] args) throws IOException {
        new Client().connection();
    }

    public void connection() throws IOException {
        Socket socket = new Socket("127.0.0.1", 7777);
        //发送消息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(FileInput.getTextContent("D:\\Users\\Administrator\\IdeaProjects\\note\\io\\src\\main\\java\\com\\beofy\\block\\io\\test.txt").getBytes(StandardCharsets.UTF_8));

        outputStream.close();
        socket.close();
    }
}
