package org.lqf.learn.designModel.adapterModel.objectEntrustAdapter;

import org.lqf.learn.designModel.adapterModel.classExtendAdapter.Print;
import org.lqf.learn.designModel.adapterModel.classExtendAdapter.PrintBanner;

public class Test {
    public static void main(String[] args) {
        Print p = new PrintBanner("hello");
        p.printWeak();
        p.printStrong();
    }
}
