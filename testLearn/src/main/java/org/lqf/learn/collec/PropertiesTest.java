package org.lqf.learn.collec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        //读文件流到 Properties
        p.load(new FileInputStream("file.txt"));
        System.out.println(p.getProperty("year"));
        p.setProperty("1","a");
        p.setProperty("2","b");
        //把流写入文件
        p.store(new FileOutputStream("newFile.txt"),"aaaa");

    }
}
