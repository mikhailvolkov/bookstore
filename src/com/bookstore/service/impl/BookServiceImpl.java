package com.bookstore.service.impl;

import com.bookstore.dao.BookDAO;
import com.bookstore.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public void insert(String name, String author, double cost, int numberOfPages, double rate) {
        bookDAO.insert(name, author, cost, numberOfPages, rate);
    }

    @Override
    public void update(int id) {
        bookDAO.update(id);
    }

    @Override
    public void delete(int id) {
        bookDAO.delete(id);
    }

    @Override
    public void getAllBooks() {
        bookDAO.getAllBooks();
    }
}
