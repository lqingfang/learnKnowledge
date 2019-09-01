package org.lqf.learn.caiBird;

//基本类型是值传递，传递的是该变量的一个副本，改变副本不影响原来变量
public class ReferenceTest {
    public static void main(String[] args) {
        int a = 10;
        test(a);
        System.out.println(a);
    }

    private static void test(int a) {
        a = 100;
    }
}
