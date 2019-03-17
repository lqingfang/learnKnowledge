package org.lqf.learn.collec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class SimpleCollection {

    //collection的添加一组元素
    private static void addArray(){
        Collection<Integer> c = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        System.out.println(c);
    }
    //collection的add()
    private static void addColl() {
        Collection<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            ((ArrayList<Integer>) c).add(i);
        }
    }
    public static void main(String[] args) {
        //addColl();
        addArray();
    }

}
