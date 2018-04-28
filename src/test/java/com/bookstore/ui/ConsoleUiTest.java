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
    @Mock
    private BookService service;
    @InjectMocks
    private ConsoleUi ui;

    @Test
    public void checkWhenReadIntInputIsNull() {
        assertEquals(0, ui.readIntInput(null));

    }

    @Test
    public void checkWhenReadDoubleInputIsNull() {
        assertEquals(0, ui.readDoubleInput(null), 0);
    }

}