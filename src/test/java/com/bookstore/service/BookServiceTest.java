package com.bookstore.service;

import com.bookstore.dao.impl.BookDaoImpl;
import com.bookstore.domain.Book;
import com.bookstore.exceptions.BookNotFoundException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class BookServiceTest {
    @Spy
    List<Book> books = new ArrayList<>();
    @InjectMocks
    private BookDaoImpl daoMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = BookNotFoundException.class)
    public void testGetById() throws BookNotFoundException {
        when(daoMock.getBookById("1111")).thenThrow(new BookNotFoundException());
    }

    @Test
    public void testInsertBook() throws BookNotFoundException {
        Book expected = new Book("12345", "Название", 300, "Автор", 5.3, 500);
        daoMock.insert(expected);
        Book actual = daoMock.getBookById(expected.getId());
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateBook() throws BookNotFoundException {
        Book book = new Book("12345", "Название", 300, "Автор", 5.3, 500);
        daoMock.insert(book);
        Book expected = new Book("12345", "Новое название", 300, "Новый автор", 5.3, 500);
        daoMock.update(expected);
        Book actual = daoMock.getBookById(expected.getId());
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteBook() {
        Book expected = new Book("12345", "Название", 300, "Автор", 5.3, 500);
        daoMock.insert(expected);
        daoMock.delete(expected);
        int expectedListSize = 0;
        assertEquals(expectedListSize, daoMock.getAllBooks().size());
    }

}