package com.kgc.entity;

public class bookInfo {
    private Integer book_id;
    private String book_name;
    private String book_author;
    private double book_price;
    private String book_pub;
    private Integer book_state;
    private Integer type_id;

    public bookInfo() {
    }

    public bookInfo(String book_name, String book_author, double book_price, String book_pub, Integer book_state, Integer type_id) {
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_price = book_price;
        this.book_pub = book_pub;
        this.book_state = book_state;
        this.type_id = type_id;
    }

    public bookInfo(Integer book_id, String book_name, String book_author, double book_price, String book_pub, Integer book_state, Integer type_id) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_price = book_price;
        this.book_pub = book_pub;
        this.book_state = book_state;
        this.type_id = type_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public double getBook_price() {
        return book_price;
    }

    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }

    public String getBook_pub() {
        return book_pub;
    }

    public void setBook_pub(String book_pub) {
        this.book_pub = book_pub;
    }

    public Integer getBook_state() {
        return book_state;
    }

    public void setBook_state(Integer book_state) {
        this.book_state = book_state;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return "bookInfo{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_author='" + book_author + '\'' +
                ", book_price=" + book_price +
                ", book_pub='" + book_pub + '\'' +
                ", book_state=" + book_state +
                ", type_id=" + type_id +
                '}';
    }
}
