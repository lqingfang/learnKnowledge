package org.lqf.learn.designModel.compositeModel;

public abstract class Entity {
    public abstract String getName();
    public abstract int size();
    protected abstract void printList(String prefix);
    public void printList(){
        printList("");
    }
    public Entity add(Entity entity) throws FileTreatmentException{
        throw new FileTreatmentException();
    }
}
