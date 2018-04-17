package com.bookstore.dao;

import com.bookstore.domain.Book;
import com.bookstore.exceptions.BookNotFoundException;

import java.util.List;

public interface BookDao {

    Book insert(Book book);

    Book update(Book book);

    void delete(Book book);

    List<Book> getAllBooks();

    Book getBookById(String id) throws BookNotFoundException;

}
