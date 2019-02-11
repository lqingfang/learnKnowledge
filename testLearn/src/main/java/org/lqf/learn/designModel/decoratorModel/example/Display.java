package org.lqf.learn.designModel.decoratorModel.example;

public abstract class Display {
    public abstract int getRows();
    public abstract int getColumns();
    public abstract String getRowText(int row);

    public void show (){
        for(int i=0;i<getRows();i++) {
            System.out.println(getRowText(i));
        }
    }
}
