package org.lqf.learn.designModel.mementoModel;

public class Test {
    public static void main(String[] args) {
        Game game = new Game(20);
        Memento memento = game.createMemento();
        for(int i=0;i<10;i++) {
            game.bet();
            if(game.getMoney()>memento.getMoney()) {
                System.out.println("before-++++--money:"+game.getMoney());
                memento = game.createMemento();
                System.out.println("money:"+game.getMoney());
            }else {
                System.out.println("before---money:"+game.getMoney());
                System.out.println("memento:"+memento.getMoney());
                game.restoreMemento(memento);
                System.out.println("money:"+game.getMoney());
            }
            System.out.println();
        }
    }
}
