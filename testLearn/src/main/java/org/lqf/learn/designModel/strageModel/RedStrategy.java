package org.lqf.learn.designModel.strageModel;

public class RedStrategy implements Strategy {
    public Hand nexHand() {
        return Hand.getHand(2);
    }

}
