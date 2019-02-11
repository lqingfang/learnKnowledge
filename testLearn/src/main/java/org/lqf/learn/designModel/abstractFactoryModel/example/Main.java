package org.lqf.learn.designModel.abstractFactoryModel.example;


import org.lqf.learn.designModel.abstractFactoryModel.example.factory.Factory;
import org.lqf.learn.designModel.abstractFactoryModel.example.factory.Link;
import org.lqf.learn.designModel.abstractFactoryModel.example.factory.Page;
import org.lqf.learn.designModel.abstractFactoryModel.example.factory.Tray;

public class Main {
    public static void main(String[] args) {

        Factory factory = Factory.getFactory("LISTFACTORY");

        Link people = factory.createLink("人民日报", "http://www.people.com.cn/");

        Tray traynews = factory.createTray("日报");

        Page page = factory.createPage("LinkPage", "杨文轩");

        traynews.add(people);
        page.add(traynews);
        page.output();
    }
}
