package org.lqf.learn.designModel.mediatorModel;

public interface Mediator {
    void addMember(Member member);
    void act(Member actor, ActionEnum actionEnum);
}
