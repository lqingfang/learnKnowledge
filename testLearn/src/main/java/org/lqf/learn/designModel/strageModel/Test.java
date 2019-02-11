package org.lqf.learn.designModel.strageModel;

public class Test {
    public static void main(String[] args) {
        Player player1 = new Player("tom",new RedStrategy());
        Player player2 = new Player("jay",new BlueStrategy());
        System.out.println(player1.nextHand());
        System.out.println(player2.nextHand());
    }
}
