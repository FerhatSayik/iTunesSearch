package com.example.itunessearch;

public class ListItem {
    private  String head,desc,img,longDesc;

    public ListItem(String head, String desc, String img, String longDesc) {
        this.head = head;
        this.desc = desc;
        this.img = img;
        this.longDesc = longDesc;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getImg() {
        return img;
    }
    public String getLongDesc() {
        return longDesc;
    }
}
