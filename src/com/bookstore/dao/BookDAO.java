package com.bookstore.dao;

public interface BookDAO {

    void insert(String name, String author, double cost, int numberOfPages, double rate);

    void update(int id);

    void delete(int id);

    void getAllBooks();
}
