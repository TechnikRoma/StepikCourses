package model;

import enums.Category;

public class Book {

    private String author;
    private Category category;
    private Integer count;
    private String description;
    private Integer price;
    private String title;

    public Book() {
    }

    public Book(String author, Category category, Integer count, String description, Integer price, String title) {
        this.author = author;
        this.category = category;
        this.count = count;
        this.description = description;
        this.price = price;
        this.title = title;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
