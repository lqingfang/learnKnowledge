package org.lqf.learn.designModel.decoratorModel.example;

public class FullBorder extends Border {
    public FullBorder(Display display) {
        super(display);
    }

    public int getRows() {
        return 1+display.getRows()+1;
    }

    public int getColumns() {
        return 1+display.getColumns()+1;
    }

    public String getRowText(int row) {         // 指定的那一行的字符串
        if (row == 0) {                                                 // 上边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (row == display.getRows() + 1) {                      // 下边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {                                                        // 其他边框
            return "|" + display.getRowText(row - 1) + "|";
        }
    }
    private String makeLine(char ch, int count) {         // 生成一个重复count次字符ch的字符串
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
