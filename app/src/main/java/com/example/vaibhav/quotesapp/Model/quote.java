package com.example.vaibhav.quotesapp.Model;

/**
 * Created by vaibhav on 6/18/17.
 */

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class quote implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("text")
    @Expose
    private String text;
    private final static long serialVersionUID = 3719461530938733859L;

    /**
     * No args constructor for use in serialization
     */
    public quote() {
    }

    /**
     * @param id
     * @param text
     * @param image
     */
    public quote(String id, String image, String text) {
        super();
        this.id = id;
        this.image = image;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}