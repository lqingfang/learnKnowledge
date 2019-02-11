package org.lqf.learn.designModel.mementoModel;

import java.util.Random;

public class Game {
    private int money;

    public Game(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private Random random = new Random();
    public void bet(){
        int num = random.nextInt(100);
        if(num<50) {
            money++;
        }else {
            money--;
        }
    }

    public Memento createMemento(){
        Memento memento = new Memento(money);
        return memento;
    }
    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
    }
}
