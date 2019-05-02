package org.lqf.learn.collec;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionTest {
    public static void main(String[] args) {
        collectionTest();
    }

    public static void collectionTest(){
        ArrayList list = new ArrayList(2);
        list.add("a");
        list.add("b");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
