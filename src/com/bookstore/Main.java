package com.bookstore;

import com.bookstore.dao.impl.BookDaoImpl;
import com.bookstore.domain.Book;
import com.bookstore.service.BookService;
import com.bookstore.service.impl.BookServiceImpl;
import com.bookstore.ui.ConsoleUi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(new Book("12345", "Название",300,"Автор",5.3,500));
        BookServiceImpl service = new BookServiceImpl(new BookDaoImpl(books));
        ConsoleUi ui = new ConsoleUi(service);
        ui.run();
    }
}
