package org.lqf.learn.designModel.observerModel;

public class ObserverDigit implements Observerr {
    public void update(GeneratorNum generatorNum) {
        System.out.println("digit:"+generatorNum.getNum());
    }
}
