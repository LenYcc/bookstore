package com.lzydmc.bookstore.model.pojo;

import java.util.Date;

public class Order {
    private Integer id;

    private String oid;

    private String userid;

    private Integer bid;

    private Long goodprice;

    private Date creatDate;

    private Date endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", oid='" + oid + '\'' +
                ", userid='" + userid + '\'' +
                ", bid=" + bid +
                ", goodprice=" + goodprice +
                ", creatDate=" + creatDate +
                ", endDate=" + endDate +
                '}';
    }
    
}