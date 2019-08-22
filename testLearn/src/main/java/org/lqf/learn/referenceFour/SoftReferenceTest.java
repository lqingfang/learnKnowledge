package org.lqf.learn.referenceFour;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {
    public static void main(String[] args) {
        Object obj = new Object();
        SoftReference sf = new SoftReference<>(obj);
        obj = null;
        System.gc();
        byte[] bytes = new byte[1024*1000];
        System.gc();
        System.out.println("是否被回收"+sf.get());
    }
}
