package com.bookstore.dao.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookField;
import com.bookstore.domain.Book;

import java.util.List;
import java.util.UUID;

public class BookDaoImpl implements BookDao {
    private List<Book> books;


    public BookDaoImpl(List<Book> books) {
        this.books = books;
    }

    @Override
    public void insert(String name, int numberOfPages, String author, double rating, int price) {
        books.add(new Book(UUID.randomUUID().toString(), name, numberOfPages, author, rating, price));
    }

    @Override
    public void update(String id, List<BookField> fieldsToUpdate) {
        Book book = books.stream().filter(elt -> elt.getId().equals(id)).findFirst().get();
        if (book != null) {
            updateFields(book, fieldsToUpdate);
        }
    }

    private void updateFields(Book book, List<BookField> fieldsToUpdate) {
        fieldsToUpdate.forEach(field -> {
            switch (field.getFieldName()) {
                case "name":
                    book.setName(field.getFieldValue());
                    break;
                case "numberOfPages":
                    book.setNumberOfPages(Integer.parseInt(field.getFieldValue()));
                    break;
                case "author":
                    book.setAuthor(field.getFieldValue());
                    break;
                case "rating":
                    book.setRating(Double.parseDouble(field.getFieldValue()));
                    break;
                case "price":
                    book.setPrice(Integer.parseInt(field.getFieldValue()));
                    break;
            }
        });
    }


    @Override
    public void delete(String id) {
        books.removeIf(elt -> elt.getId().equals(id));
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }
}
