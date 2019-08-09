package com.alomateam.gainapp.Card;

public class CardInfo {
    public int drawableId;
    public String name;

    public CardInfo(int drawableId, String name){
        this.drawableId = drawableId;
        this.name = name;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
