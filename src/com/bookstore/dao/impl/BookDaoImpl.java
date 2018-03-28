package com.bookstore.dao.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.domain.Book;
import com.bookstore.exceptions.BookNotFoundException;

import java.util.List;
import java.util.Map;

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
       books.removeIf(elt -> elt.getId().equals(book.getId()));
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

    @Override
    public Book getBookById(String id) throws BookNotFoundException {
        return getAllBooks().stream().filter(res -> res.getId().equals(id)).findFirst().orElseThrow(BookNotFoundException::new);
    }
}
