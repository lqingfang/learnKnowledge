package org.lqf.learn.soGoTest;

public class UserTest {
    public static void calculate(User user){
        user = new User();
        user.age = 100;
    }
    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.age);
        calculate(user);
        System.out.println(user.age);
    }
}
