package org.lqf.learn.designModel.mediatorModel;

public class Test {
    public static void main(String[] args) {
        // 创建一个小组
        Mediator party = new MediatorImpl();

        // 有三种人
        Andersen andersen = new Andersen();
        Fairy fairy = new Fairy();
        Chef chef = new Chef();

        // 这三种人都加入到了小组中
        party.addMember(andersen);
        party.addMember(fairy);
        party.addMember(chef);
        System.out.println("-------------------");

        // 安徒生要讲故事, 中介者就会通知其他人.
        andersen.act(ActionEnum.TALE);
        System.out.println("-------------------");

        // 精灵发现了鲜花, 中介者就会通知其他所有人
        fairy.act(ActionEnum.FOND);
        System.out.println("-------------------");

        //厨师做好了饭, 中介者就会通知其他所有人
        chef.act(ActionEnum.HUNT);
    }
}
