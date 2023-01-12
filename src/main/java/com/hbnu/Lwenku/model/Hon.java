package com.hbnu.Lwenku.model;

import java.util.Date;

public class Hon {
    private Integer id;
    private String cover;
    private String name;
    private String author;
    private int heat;
    private Date date;
    private String price;
    private int recommend;

    @Override
    public String toString() {
        return "Hon{" +
                "id=" + id +
                ", cover='" + cover + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", heat=" + heat +
                ", date=" + date +
                ", price='" + price + '\'' +
                ", recommend=" + recommend +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }
}
