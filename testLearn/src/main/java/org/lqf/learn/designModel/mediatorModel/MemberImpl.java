package org.lqf.learn.designModel.mediatorModel;

public abstract class MemberImpl implements Member {
    protected Mediator mediator;

    public void joinedParty(Mediator mediator) {
        System.out.printf("%s 加入到了小组中\n", this);
        this.mediator = mediator;
    }

    public void partyAction(ActionEnum actionEnum) {
        System.out.printf("%s %s\n", this, actionEnum.getDescription());
    }

    public void act(ActionEnum actionEnum) {
        if (mediator != null) {
            System.out.printf("%s %s\n", this, actionEnum);
            mediator.act(this, actionEnum);
        }
    }

    public abstract String toString();
}
