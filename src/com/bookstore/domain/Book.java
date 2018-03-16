package com.bookstore.domain;

public class Book {
    private String id;
    private String name;
    private int numberOfPages;
    private String author;
    private double rating;
    private int price;

    public Book(String id, String name, int numberOfPages, String author, double rating, int price) {
        this.id = id;
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.rating = rating;
        this.price = price;
    }

    public String getId() {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
