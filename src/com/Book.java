package com;

import java.io.Serializable;

//Book类中有关于书的信息
class Book implements Serializable {

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", state=" + state +
                '}';
    }

    public Book() {
    }

    private String name;
    //书名

    private String author;
    //作者

    private int price;
    //价格

    private String category;
    //种类

    private boolean state;
    //状态 true-未借出
    //    false-已借出


    //通过构造函数给出书的属性
    Book(String name,String author,int price,String category,boolean state){
        this.name = name;
        this.author = author;
        this.price = price;
        this.category = category;
        this.state = state;

    }

    //各种关于书的属性的获取和设置
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isState() {

        return state;
    }

    public void setState(boolean state) {

        this.state = state;
    }

    public String getCategory() {

        return category;
    }

    public void setCategory(String category) {

        this.category = category;
    }
}