package org.lqf.learn.designModel.adapterModel.exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO {

    public String getValue(String key) {
        return getProperty(key);
    }

    public void setValue(String key, String value) {
        setProperty(key,value);
    }

    public void readFormFile(String filename) throws IOException {
        load(new FileInputStream(filename));
    }

    public void writeToFile(String filename) throws IOException {
        store(new FileOutputStream(filename),"written by FileProperties");
    }


}
