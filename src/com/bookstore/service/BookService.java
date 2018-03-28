package com.bookstore.service;

import com.bookstore.domain.Book;
import com.bookstore.exceptions.BookNotFoundException;

import java.util.List;

public interface BookService {
    void insert(Book book);

    void update(Book book) throws BookNotFoundException;

    void delete(Book book) throws BookNotFoundException;

    List<Book> getAllBooks();

    Book getBookById(String id);
}
