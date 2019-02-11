package org.lqf.learn.designModel.stateModel;

public class StateStop implements State {
    public void doAction(Context context) {
        System.out.println("in stop state");
        context.setState(this);
    }
    public String toString() {
        return "stop state";
    }
}
