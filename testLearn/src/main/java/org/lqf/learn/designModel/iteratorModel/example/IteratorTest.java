package org.lqf.learn.designModel.iteratorModel.example;

public class IteratorTest {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("around me"));
        bookShelf.appendBook(new Book("beyond you"));
        bookShelf.appendBook(new Book("control you"));
        bookShelf.appendBook(new Book("destory you"));
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = (Book)iterator.next();
            System.out.println(book.getName());
        }
    }
}
