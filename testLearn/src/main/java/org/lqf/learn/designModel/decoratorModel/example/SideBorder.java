package org.lqf.learn.designModel.decoratorModel.example;

public class SideBorder extends Border {
    private char borderChar;

    public SideBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    public int getRows() {
        return display.getRows();
    }

    public int getColumns() {
        return 1+display.getColumns()+1;
    }

    public String getRowText(int row) {
        return borderChar+display.getRowText(row)+borderChar;
    }
}
