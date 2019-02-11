package org.lqf.learn.designModel.abstractFactoryModel.example.listfactory;


import org.lqf.learn.designModel.abstractFactoryModel.example.factory.Factory;
import org.lqf.learn.designModel.abstractFactoryModel.example.factory.Link;
import org.lqf.learn.designModel.abstractFactoryModel.example.factory.Page;
import org.lqf.learn.designModel.abstractFactoryModel.example.factory.Tray;

public class ListFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
