package com.bookstore.ui;

public class BookField {
    private String fieldName;
    private String fieldValue;

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
