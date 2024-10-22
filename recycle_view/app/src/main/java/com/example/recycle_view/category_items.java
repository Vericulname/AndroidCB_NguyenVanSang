package com.example.recycle_view;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;

public class category_items implements Serializable {
    public int type = 1;
    String title;
    Drawable image;
    ArrayList<story_item> stories;

    public category_items(String title, Drawable image, ArrayList<story_item> stories) {
        this.title = title;
        this.image = image;
        this.stories = stories;
    }

    public ArrayList<story_item> getStories() {
        return stories;
    }

    public void setStories(ArrayList<story_item> stories) {
        this.stories = stories;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
