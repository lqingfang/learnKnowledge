package org.lqf.learn.designModel.mediatorModel;

import java.util.ArrayList;
import java.util.List;

public class MediatorImpl implements Mediator {
    private final List<Member> members;

    public MediatorImpl() {
        members = new ArrayList<Member>();
    }

    public void act(Member actor, ActionEnum actionEnum) {
        for (Member member : members) {
            if (!member.equals(actor)) {
                member.partyAction(actionEnum);
            }
        }
    }

    public void addMember(Member member) {
        members.add(member);
        member.joinedParty(this);
    }
}
