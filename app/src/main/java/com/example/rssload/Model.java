package com.example.rssload;

public class Model {
    private String title;
    private String link;
    private String img;
    private String des;

    public Model(String title, String link, String img, String des) {
        this.title = title;
        this.link = link;
        this.img = img;
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
