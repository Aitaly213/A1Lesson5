package com.geektech.a1lesson5;

import android.widget.ImageView;

import java.io.Serializable;

public class RecyclerModel implements Serializable {
    private String title;
    private String subtitle;
    private int image1;

    public RecyclerModel(String title, String subtitle, int imageView) {
        this.title = title;
        this.subtitle = subtitle;
        this.image1 = imageView;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
