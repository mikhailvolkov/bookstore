package com.bookstore.dao.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.domain.Book;

import java.util.List;

public class BookDaoImpl implements BookDao {
    private List<Book> books;


    public BookDaoImpl(List<Book> books) {
        this.books = books;
    }

    @Override
    public void insert(Book book) {
        books.add(book);
    }

    @Override
    public void update(Book book) {
       books.remove(book);
       books.add(book);
    }


    @Override
    public void delete(Book book) {
        books.remove(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }
}
