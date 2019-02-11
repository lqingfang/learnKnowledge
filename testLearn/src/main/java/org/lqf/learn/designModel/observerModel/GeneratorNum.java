package org.lqf.learn.designModel.observerModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class GeneratorNum {
    private List observerrList = new ArrayList();
    public void addObserverr(Observerr observerr){
        observerrList.add(observerr);
    }
    public void notifyAl() {
        Iterator iterator = observerrList.iterator();
        while (iterator.hasNext()) {
            Observerr observerr = (Observerr) iterator.next();
            observerr.update(this);
        }
    }

    public abstract int getNum();
    public abstract void execute();
}
