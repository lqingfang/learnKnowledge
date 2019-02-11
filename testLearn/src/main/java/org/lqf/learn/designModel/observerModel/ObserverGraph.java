package org.lqf.learn.designModel.observerModel;

public class ObserverGraph implements Observerr {
    public void update(GeneratorNum generatorNum) {
        int num = generatorNum.getNum();
        for (int i=0;i<num;i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
