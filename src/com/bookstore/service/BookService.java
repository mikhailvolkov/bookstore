package com.bookstore.service;

public interface BookService {
    void insert(String name, String author, double cost, int numberOfPages, double rate);

    void update(int id);

    void delete(int id);

    void getAllBooks();
}
