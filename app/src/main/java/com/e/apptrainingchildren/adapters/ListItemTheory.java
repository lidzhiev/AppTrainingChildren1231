package com.e.apptrainingchildren.adapters;

import android.graphics.drawable.Drawable;

public class ListItemTheory {
    private String title;
    private String content;
    private int drawable;
    private int id;


    public ListItemTheory(String title, String content, int drawable, int id){
        this.title = title;
        this.content = content;
        this.drawable = drawable;
        this.id = id;
    }
    public ListItemTheory(){

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
