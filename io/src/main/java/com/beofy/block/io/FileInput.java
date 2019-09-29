package com.beofy.block.io;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FileInput {

    public static void main(String[] args) throws IOException {
            System.out.print(getTextContent("D:\\Users\\Administrator\\IdeaProjects\\note\\io\\src\\main\\java\\com\\beofy\\block\\io\\test.txt"));
    }


    /**
     * 获取文本内容
     * @return
     */
    public static String getTextContent(String path) {
        InputStream inputStream = null;
        try {
             inputStream = new FileInputStream(path);

            byte[] temp = new byte[2048];
            int length;
            StringBuilder buffer = new StringBuilder();
            while ((length = inputStream.read(temp)) != -1){
                buffer.append(new String(temp,0,length,StandardCharsets.UTF_8));
            }

            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream!=null) inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
