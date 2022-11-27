package com.example.rssload;

public class Model2 {
    private String listTittle;
    private String listLink;
    private int listImg;

    public Model2(String listTittle, String listLink, int listImg) {
        this.listTittle = listTittle;
        this.listLink = listLink;
        this.listImg = listImg;
    }

    public String getListTittle() {
        return listTittle;
    }

    public void setListTittle(String listTittle) {
        this.listTittle = listTittle;
    }

    public String getListLink() {
        return listLink;
    }

    public void setListLink(String listLink) {
        this.listLink = listLink;
    }

    public int getListImg() {
        return listImg;
    }

    public void setListImg(int listImg) {
        this.listImg = listImg;
    }
}
