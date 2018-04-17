package com.bookstore.service;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.impl.BookDaoImpl;
import com.bookstore.domain.Book;
import com.bookstore.exceptions.BookNotFoundException;
import com.bookstore.service.impl.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookDao bookDao;


    @Test(expected = BookNotFoundException.class)
    public void verifyThatThrowsNotFoundExceptionWhenBookDoesntExist() throws BookNotFoundException {
        // WHEN
        when(bookDao.getBookById("1111")).thenThrow(new BookNotFoundException());
        bookService.getBookById("1111");
    }

    @Test
    public void checkThatReturnsTheSameBookWhenInsert() {
        // GIVEN
        Book expected = new Book("12345", "Название", 300, "Автор", 5.3, 500);

        // WHEN
        when(bookDao.insert(expected)).thenReturn(expected);
        Book insertedBook = bookService.insert(expected);

        // THEN
        assertEquals(expected, insertedBook);
    }


    @Test
    public void checkThatBooksSizeIncreaseByOneWhenInsertNewOne() {
        // GIVEN
        Book expected = new Book("12345", "Название", 300, "Автор", 5.3, 500);

        // WHEN
        when(bookDao.getAllBooks()).thenReturn(Collections.singletonList(expected));
        bookService.insert(expected);

        // THEN
        assertEquals(bookService.getAllBooks().size(), 1);
    }

    @Test
    public void checkThatReturnsTheSameBookWhenUpdate() {
        // GIVEN
        Book book = new Book("12345", "Новое название", 300, "Новый автор", 5.3, 500);

        // WHEN
        when(bookDao.update(book)).thenReturn(book);
        Book updatedBook = bookService.update(book);

        // THEN
        assertEquals(book, updatedBook);
    }

    @Test
    public void checkThatBookSizeDecreaseWhenDeletedOne() {
        // GIVEN
        Book expected = new Book("12345", "Новое название", 300, "Новый автор", 5.3, 500);

        // WHEN
        when(bookDao.getAllBooks()).thenReturn(Collections.emptyList());
        bookService.delete(expected);

        // THEN
        assertEquals(bookService.getAllBooks().size(), 0);
    }

}