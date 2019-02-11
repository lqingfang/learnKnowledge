package org.lqf.learn.designModel.singletonModel.exercise02;

public class Triple {
    private static Triple[] triples = new Triple[]{
            new Triple(0),
            new Triple(1),
            new Triple(2)
    };
    private int i;
    private Triple(int i) {
        this.i = i;
    }
    public static Triple getInstance(int i){
        return triples[i];
    }

    @Override
    public String toString() {
        return "triple i:"+this.i;
    }
}
