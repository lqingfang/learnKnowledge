package org.lqf.learn.designModel.strageModel;

public class Hand {
    public static final int HANDVALUE_GUU = 0;
    public static final int HANDVALUE_CHO = 1;
    public static final int HANDVALUE_PAA = 2;
    public static final Hand[] hand = {
            new Hand(HANDVALUE_GUU),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_PAA),
    };
    private static final String[] name = {"黄","红","蓝"};
    private int handValue;

    public Hand(int handValue) {
        this.handValue = handValue;
    }
    public static Hand getHand(int handvalue) { // 根据手势的值获取其对应的实例
        return hand[handvalue];
    }
    public String toString(){
        return name[handValue];
    }
}
