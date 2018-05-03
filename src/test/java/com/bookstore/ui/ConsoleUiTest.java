package com.bookstore.ui;


import com.bookstore.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleUiTest {
    @InjectMocks
    private ConsoleUi ui;
    @Mock
    private BookService service;


    @Test
    public void checkThatReadIntInputReturnsZeroWhenStringIsNull() {
        assertEquals(0, ui.readIntInput(null));

    }

    @Test
    public void checkThatReadDoubleInputReturnsZeroWhenStringIsNull() {
        assertEquals(0, ui.readDoubleInput(null), 0);
    }

}