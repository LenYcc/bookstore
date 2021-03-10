package com.lzydmc.bookstore.model.pojo;

public class BookImg {
    private Long id;

    private Long bid;

    private String mainsrc;

    private String src1;

    private String src2;

    private String src3;

    private String src4;

    private String src5;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getMainsrc() {
        return mainsrc;
    }

    public void setMainsrc(String mainsrc) {
        this.mainsrc = mainsrc == null ? null : mainsrc.trim();
    }

    public String getSrc1() {
        return src1;
    }

    public void setSrc1(String src1) {
        this.src1 = src1 == null ? null : src1.trim();
    }

    public String getSrc2() {
        return src2;
    }

    public void setSrc2(String src2) {
        this.src2 = src2 == null ? null : src2.trim();
    }

    public String getSrc3() {
        return src3;
    }

    public void setSrc3(String src3) {
        this.src3 = src3 == null ? null : src3.trim();
    }

    public String getSrc4() {
        return src4;
    }

    public void setSrc4(String src4) {
        this.src4 = src4 == null ? null : src4.trim();
    }

    public String getSrc5() {
        return src5;
    }

    public void setSrc5(String src5) {
        this.src5 = src5 == null ? null : src5.trim();
    }

    @Override
    public String toString() {
        return "BookImg{" +
                "id=" + id +
                ", bid=" + bid +
                ", mainsrc='" + mainsrc + '\'' +
                ", src1='" + src1 + '\'' +
                ", src2='" + src2 + '\'' +
                ", src3='" + src3 + '\'' +
                ", src4='" + src4 + '\'' +
                ", src5='" + src5 + '\'' +
                '}';
    }
}