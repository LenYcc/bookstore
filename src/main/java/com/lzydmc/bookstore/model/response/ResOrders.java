package com.lzydmc.bookstore.model.response;

import java.util.Date;

public class ResOrders {

    private String oid;

    private Integer bid;

    private String name;

    private String image;

    private Long goodprice;

    private Date creatDate;


    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Long getGoodprice() {
        return goodprice;
    }

    public void setGoodprice(Long goodprice) {
        this.goodprice = goodprice;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }


}
