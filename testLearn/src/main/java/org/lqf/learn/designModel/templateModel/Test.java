package org.lqf.learn.designModel.templateModel;

public class Test {
    public static void main(String[] args) {
        AbstractDisplay ad = new CharDisplay('a');
        ad.display();
        AbstractDisplay sd = new StringDisplay("hello");
        sd.display();
    }
}
