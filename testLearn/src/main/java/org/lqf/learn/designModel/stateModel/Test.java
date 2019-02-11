package org.lqf.learn.designModel.stateModel;

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        StateStart stateStart = new StateStart();
        stateStart.doAction(context);
        System.out.println(stateStart);

        StateStop stateStop = new StateStop();
        stateStop.doAction(context);
        System.out.println(stateStop);
    }
}
