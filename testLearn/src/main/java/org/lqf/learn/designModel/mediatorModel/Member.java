package org.lqf.learn.designModel.mediatorModel;

public interface Member {
    void joinedParty(Mediator mediator);

    void partyAction(ActionEnum actionEnum);

    void act(ActionEnum actionEnum);
}
