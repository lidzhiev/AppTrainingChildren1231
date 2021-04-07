package com.e.apptrainingchildren.adapters;

import java.util.HashMap;

public class ListItemTheoryContent {
    private String word;

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    private int drawable;
    private int sound;

    public ListItemTheoryContent(String word, int drawable, int sound){
        this.word = word;
        this.drawable = drawable;
        this.sound = sound;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }


}
