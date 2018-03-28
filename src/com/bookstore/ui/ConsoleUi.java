package com.bookstore.ui;

import com.bookstore.domain.Book;
import com.bookstore.exceptions.BookNotFoundException;
import com.bookstore.service.BookService;

import java.util.HashMap;
import java.util.Map;

public class ConsoleUi extends AbstractСonsoleUi {

    private BookService bookService;

    public ConsoleUi(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    protected int printMainActions() {
        System.out.println(" 1) Добавить книгу");
        System.out.println(" 2) Удалить книгу");
        System.out.println(" 3) Обновить книгу");
        System.out.println(" 4) Показать все книги");
        return 4;
    }

    @Override
    public final void runAction(int action) {
        switch (action) {
            case 1:
                createBook();
                break;
            case 2:
                deleteBook();
                break;
            case 3:
                updateBook();
                break;
            case 4:
                printAllBooks();
                break;
        }
    }


    private void createBook() {
        String id = readStringInput("Id книги: ");
        String name = readStringInput("Название книги: ");
        int numberOfPages = readIntInput("Количество страниц: ");
        String author = readStringInput("Автор: ");
        double rating = readDoubleInput("Рейтинг: ");
        int price = readIntInput("Цена: ");

        Book book = new Book(id, name, numberOfPages, author, rating, price);
        bookService.insert(book);
        System.out.println("Книга добавлена!");
    }

    private void deleteBook() {
        String id = readStringInput("Введите id книги: ");
        Book book = null;
        try {
            book = bookService.getBookById(id);
        } catch (BookNotFoundException ex) {
            System.out.println("Указанная книга не найдена!");
        }
        if (book != null) {
            bookService.delete(book);
            System.out.println("Книга обновлена!");
        }
    }

    private void updateBook() {
        String id = readStringInput("Введите id книги: ");
        Book book = null;
        try {
            book = bookService.getBookById(id);
        } catch (BookNotFoundException ex) {
            System.out.println("Указанная книга не найдена!");
            return;
        }
        System.out.println("Введите через запятую номера полей которые нужно обновить:\n");
        String fields = readStringInput("1) Название \n" +
                "2) Количество страниц \n" +
                "3) Автор \n" +
                "4) Рейтинг \n" +
                "5) Цена\n");
        String[] fieldsMas = fields.split(",");
        String values = readStringInput("Введите через запятую новые значения полей: \n ");
        String[] valuesMas = values.split(",");
        Map<Integer, String> valuesMap = new HashMap<>();
        for (int i = 0; i < fieldsMas.length; i++) {
            valuesMap.put(Integer.parseInt(fieldsMas[i]), valuesMas[i]);
        }
        updateFields(book, valuesMap);
        if (book != null) {
            bookService.update(book);
            System.out.println("Книга обновлена!");
        }
    }


    private void updateFields(Book book, Map<Integer, String> fields) {
        for (Integer key : fields.keySet()) {
            switch (key) {
                case 1:
                    book.setName(fields.get(key));
                    break;
                case 2:
                    book.setNumberOfPages(Integer.parseInt(fields.get(key)));
                    break;
                case 3:
                    book.setAuthor(fields.get(key));
                    break;
                case 4:
                    book.setRating(Double.parseDouble(fields.get(key)));
                    break;
                case 5:
                    book.setPrice(Integer.parseInt(fields.get(key)));
                    break;
            }
        }
    }

    private void printAllBooks() {
        bookService.getAllBooks().forEach(elt -> {
            System.out.println("id: " + elt.getId() + "\n" +
                    "название: " + elt.getName() + "\n"+
                    "количество страниц: " + elt.getPrice() + "\n"+
                    "автор: " + elt.getAuthor() + "\n" +
                    "рейтинг: " + elt.getRating() + "\n" +
                    "стоимость: " + elt.getPrice() + "\n"
            );
        });
    }

}
