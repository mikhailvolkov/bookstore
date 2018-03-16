package com.bookstore.service;

import com.bookstore.dao.BookField;
import com.bookstore.domain.Book;

import java.util.List;

public interface BookService {
    void insert(String name, int numberOfPages, String author, double rating, int price);

    void update(String id, List<BookField> fieldsToUpdate);

    void delete(String id);

    List<Book> getAllBooks();
}