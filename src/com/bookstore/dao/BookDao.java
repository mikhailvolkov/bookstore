package com.bookstore.dao;

import com.bookstore.domain.Book;

import java.util.List;

public interface BookDao {

    void insert(String name, int numberOfPages, String author, double rating, int price);

    void update(String id, List<BookField> fieldsToUpdate);

    void delete(String id);

    List<Book> getAllBooks();
}
