package com.bookstore.ui;

import com.bookstore.domain.Book;
import com.bookstore.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class ConsoleUi extends AbstractState {

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


    public void createBook() {
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

    protected void deleteBook() {
        String id = readStringInput("Введите id книги: ");
        Book book = bookService.getAllBooks().stream().filter(res -> res.getId().equals(id)).findFirst().get();
        bookService.delete(book);
        System.out.println("Книга удалена!");
    }

    protected void updateBook() {
        String id = readStringInput("Введите id книги: ");
        Book book = bookService.getAllBooks().stream().filter(res -> res.getId().equals(id)).findFirst().get();
        String fields = readStringInput("Введите через запятую название полей которые нужно обновить(name, numberOfPages, author, rating, price) ");
        String[] fieldsMas = fields.split(",");
        String values = readStringInput("Введите через запятую новые значения полей ");
        String[] valuesMas = fields.split(",");
        List<BookField> fieldsToUpdate = new ArrayList<>();
        updateFields(book, fieldsMas, valuesMas);

    }

    private void updateFields(Book book, String[] fields, String[] values) {
        for (int i = 0; i < fields.length; i++) {
            switch (fields[i]) {
                case "name":
                    book.setName(values[i]);
                    break;
                case "numberOfPages":
                    book.setNumberOfPages(Integer.parseInt(values[i]));
                    break;
                case "author":
                    book.setAuthor(values[i]);
                    break;
                case "rating":
                    book.setRating(Double.parseDouble(values[i]));
                    break;
                case "price":
                    book.setPrice(Integer.parseInt(values[i]));
                    break;
            }
        }
    }

    private void printAllBooks() {
        bookService.getAllBooks().forEach(elt -> {
            System.out.println("id: " + elt.getId() + "\n" +
                    "название: " + elt.getName() + "\n" +
                    "автор: " + elt.getAuthor() + "\n" +
                    "стоимость: " + elt.getPrice() + "\n");
        });
    }

}
