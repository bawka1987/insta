package com.bawka.Model;

import java.util.ArrayList;

public class User {
    int id;
    ArrayList<String> taglist;

    public int getId() {
        return id;
    }

    public ArrayList<String> getTaglist() {
        return taglist;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTaglist(ArrayList<String> taglist) {
        this.taglist = taglist;
    }
}
