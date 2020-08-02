package com.beofy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;

public class HttpDemo {

    public static void main(String[] args) throws IOException {
        String path = "";
        String host = "https://interface.dtslb.com/gw";
        int port = 443;
        Socket socket = new Socket();
        InetSocketAddress address=new InetSocketAddress(host, port);
        socket.connect(address,3000);
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(),"utf-8");
        osw.write("GET " + path + " HTTP/1.1\r\n");
        osw.write("Host: " + host + " \r\n");
        //http协议必须在报文头后面再加一个换行，通知服务器发送完成，不然服务器会一直等待
        osw.write("\r\n");
        osw.flush();
        socket.shutdownOutput();

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), "utf-8"));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        osw.close();
        bufferedReader.close();
        socket.close();

    }
}
