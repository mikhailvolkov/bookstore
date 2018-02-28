package com.bookstore.dao.impl;

import com.bookstore.dao.BookDAO;
import com.bookstore.domain.Book;

import java.util.List;

public class BookDAOImpl implements BookDAO{
    private List<Book> books;

    public BookDAOImpl(List<Book> books) {
        this.books = books;
    }

    @Override
    public void insert(String name, String author, double cost, int numberOfPages, double rate) {
    }

    @Override
    public void update(int id) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void getAllBooks() {
    }
}
