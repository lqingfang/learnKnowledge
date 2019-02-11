package org.lqf.learn.designModel.strageModel;

public class BlueStrategy implements Strategy {
    public Hand nexHand() {
        return Hand.getHand(1);
    }
}
