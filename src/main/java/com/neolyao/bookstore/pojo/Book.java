package com.neolyao.bookstore.pojo;

public class Book {
    private String  bid;
    private String  bname;
    private String  author;
    private float   price;
    private float   curprice;
    private String  press;
    private String  src;
    private Category category;
    private int     number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCurprice() {
        return curprice;
    }

    public void setCurprice(float curprice) {
        this.curprice = curprice;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", curprice=" + curprice +
                ", press='" + press + '\'' +
                ", src='" + src + '\'' +
                ", category=" + category +
                ", number=" + number +
                '}';
    }
}
