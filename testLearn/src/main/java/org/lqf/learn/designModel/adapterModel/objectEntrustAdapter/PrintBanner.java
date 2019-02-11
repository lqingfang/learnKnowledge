package org.lqf.learn.designModel.adapterModel.objectEntrustAdapter;

public class PrintBanner extends Print {
    Banner banner;

    public PrintBanner(String str) {
        banner = new Banner(str);
    }

    public void printWeak() {
        banner.showWithParen();
    }

    public void printStrong() {
        banner.showWithAster();
    }
}
