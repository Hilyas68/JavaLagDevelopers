package com.hcode.javalagdevelopers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hassan on 11/22/2017.
 */

public class ItemResponse {
    @SerializedName("items")
    @Expose

    private List<Item> items;

    public ItemResponse(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
