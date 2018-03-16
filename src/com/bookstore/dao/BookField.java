package com.bookstore.dao;

/*
Класс для обновления полей в book
 */
public class BookField {
    private final String fieldName;//название поля которое хотим обновить
    private final String fieldValue;//новое значение

    public BookField(String fieldName, String fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }
}