package com.example.vaibhav.quotesapp.Model;

/**
 * Created by vaibhav on 6/18/17.
 */

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONResponse implements Serializable {

    @SerializedName("quotes")
    @Expose
    private List<quote> quotes = null;
    private final static long serialVersionUID = 9076018219064381458L;

    /**
     * No args constructor for use in serialization
     */
    public JSONResponse() {
    }

    /**
     * @param quotes
     */
    public JSONResponse(List<quote> quotes) {
        super();
        this.quotes = quotes;
    }

    public List<quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<quote> quotes) {
        this.quotes = quotes;
    }

}