package org.lqf.learn.designModel.prototypeModel.framework;

public interface Product extends Cloneable {
    public abstract void use();
    public abstract Product creatClone() throws CloneNotSupportedException;

}
