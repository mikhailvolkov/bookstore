package com.bookstore.domain;

public class Book {
    private int id;
    private String name;
    private int numberOfPages;
    private String author;
    private double rating;
    private int price;

    public Book(int id, String name, int numberOfPages, String author, double rating, int price) {
        this.id = id;
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.rating = rating;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public double getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }
}
