package org.lqf.learn.designModel.stateModel;

public class StateStart implements State {
    public void doAction(Context context) {
        System.out.println("in start state");
        context.setState(this);
    }
    public String toString() {
        return "start state";
    }
}
