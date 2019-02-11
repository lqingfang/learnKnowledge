package org.lqf.learn.designModel.adapterModel.exercise;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        FileIO f = new FileProperties();
        f.readFormFile("file.txt");
        f.setValue("year","2004");
        f.setValue("month","4");
        f.setValue("day","21");
        f.writeToFile("newFile.txt");
    }
}
