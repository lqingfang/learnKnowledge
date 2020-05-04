package org.lqf.learn.algorithm.meiCai;

//基本类型是值传递，传递的是该变量的一个副本，改变副本不影响原来变量
public class ReferenceTest {
    public static void main(String[] args) {
        int a = 10;
        String str = "hello";
        test(a,str);
        System.out.println(a+":"+str);
    }

    private static void test(int a,String str) {
        str = "hi";
        a = 100;
    }
}
