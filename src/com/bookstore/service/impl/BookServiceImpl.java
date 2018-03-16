package com.bookstore.service.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookField;
import com.bookstore.domain.Book;
import com.bookstore.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void insert(String name, int numberOfPages, String author, double rating, int price) {
        bookDao.insert(name, numberOfPages, author, rating, price);
    }

    @Override
    public void update(String id, List<BookField> fieldsToUpdate) {
        bookDao.update(id, fieldsToUpdate);
    }

    @Override
    public void delete(String id) {
        bookDao.delete(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}
