package com.lzydmc.bookstore.model.request;

import java.util.Date;

public class Booksrc {

    private Integer id;

    private String name;

    private String author;

    private String publisher;

    private String image;

    private String detail;

    private Integer price;

    private Integer stock;

    private Integer status;

    private String mainsrc;

    private String src1;

    private String src2;

    private String src3;

    private String src4;

    private String src5;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMainsrc() {
        return mainsrc;
    }

    public void setMainsrc(String mainsrc) {
        this.mainsrc = mainsrc;
    }

    public String getSrc1() {
        return src1;
    }

    public void setSrc1(String src1) {
        this.src1 = src1;
    }

    public String getSrc2() {
        return src2;
    }

    public void setSrc2(String src2) {
        this.src2 = src2;
    }

    public String getSrc3() {
        return src3;
    }

    public void setSrc3(String src3) {
        this.src3 = src3;
    }

    public String getSrc4() {
        return src4;
    }

    public void setSrc4(String src4) {
        this.src4 = src4;
    }

    public String getSrc5() {
        return src5;
    }

    public void setSrc5(String src5) {
        this.src5 = src5;
    }

    @Override
    public String toString() {
        return "Booksrc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", image='" + image + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", status=" + status +
                ", mainsrc='" + mainsrc + '\'' +
                ", src1='" + src1 + '\'' +
                ", src2='" + src2 + '\'' +
                ", src3='" + src3 + '\'' +
                ", src4='" + src4 + '\'' +
                ", src5='" + src5 + '\'' +
                '}';
    }

//    INSERT INTO demo (name) values ('add');
//    SELECT @@IDENTITY
}
