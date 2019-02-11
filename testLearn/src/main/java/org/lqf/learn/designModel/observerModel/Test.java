package org.lqf.learn.designModel.observerModel;

public class Test {
    public static void main(String[] args) {
        GeneratorNum g = new GeneratorNumImpl();
        g.addObserverr(new ObserverDigit());
        g.addObserverr(new ObserverGraph());
        g.execute();
    }
}
