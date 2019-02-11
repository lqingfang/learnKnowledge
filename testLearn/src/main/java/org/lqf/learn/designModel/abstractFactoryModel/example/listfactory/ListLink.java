package org.lqf.learn.designModel.abstractFactoryModel.example.listfactory;


import org.lqf.learn.designModel.abstractFactoryModel.example.factory.Link;

public class ListLink extends Link {
    public ListLink(String caption, String url) {
        super(caption, url);
    }
    public String makeHTML() {
        return "  <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}
