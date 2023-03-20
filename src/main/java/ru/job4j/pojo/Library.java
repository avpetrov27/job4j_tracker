package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Java The Complete Reference", 1344);
        Book book2 = new Book("Java. Library professional", 864);
        Book book3 = new Book("Head First Java", 716);
        Book book4 = new Book("Clean code", 464);
        Book[] books = {book1, book2, book3, book4};
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getCount());
        }
        books[0] = book4;
        books[3] = book1;
        System.out.println();
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getCount());
        }
    }
}
