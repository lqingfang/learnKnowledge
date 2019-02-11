package org.lqf.learn.designModel.adapterModel.exercise;

import java.io.IOException;

public interface FileIO {
    public String getValue(String key);
    public void setValue(String key,String value);
    public void readFormFile(String filename) throws IOException;
    public void writeToFile(String filename) throws IOException;

}
