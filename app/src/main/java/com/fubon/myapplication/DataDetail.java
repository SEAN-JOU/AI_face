package com.fubon.myapplication;

import java.io.Serializable;

/**
 * Created by jou on 2017/12/25.
 */

public  class DataDetail implements Serializable {


    String text;
    String imageUrl;

    public DataDetail(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }}

