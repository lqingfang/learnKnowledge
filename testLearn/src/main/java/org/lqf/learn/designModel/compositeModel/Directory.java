package org.lqf.learn.designModel.compositeModel;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entity{
    private String name;
    private ArrayList directoryList = new ArrayList();

    public Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int size() {
        int size = 0;
        Iterable it = (Iterable) directoryList.iterator();
        if(((Iterator) it).hasNext()) {
            Entity entity = (Entity) ((Iterator) it).next();
            size += entity.size();
        }
        return size;
    }

    public Entity add(Entity entity) {
        directoryList.add(entity);
        return this;
    }
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator it = directoryList.iterator();
        while (it.hasNext()) {
            Entity entry = (Entity)it.next();
            entry.printList(prefix + "/" + name);
        }
    }
}
