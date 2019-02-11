package org.lqf.learn.designModel.compositeModel;

public class File extends Entity {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int size() {
        return size;
    }

    protected void printList(String prefix) {
        System.out.println(prefix+"/"+this);
    }
}
