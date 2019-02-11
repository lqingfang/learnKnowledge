package org.lqf.learn.designModel.adapterModel.classExtendAdapter;

public class PrintBanner extends Banner implements Print {
    public PrintBanner(String str) {
        super(str);
    }

    public void printWeak() {
        showWithParen();
    }

    public void printStrong() {
        showWithAster();
    }
}
