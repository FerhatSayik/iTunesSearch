package com.example.itunessearch;

public class ListItem {
    private  String head;
    private String desc;
    private  String img;

    public ListItem(String head, String desc, String img) {
        this.head = head;
        this.desc = desc;
        this.img = img;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getİmg() {
        return img;
    }
}
