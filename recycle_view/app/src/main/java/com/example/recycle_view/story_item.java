package com.example.recycle_view;

import java.io.Serializable;

public class story_item implements Serializable {


    public int type = 2;
    String title;
    String story;

    public story_item(String story,String title) {
        this.story = story;
        this.title = title;

    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
