package com.example.layouts.ByRestApi;

public class ListItems {

    private String Name;
    private String Desc;
    private String ImageUrl;

    public ListItems(String name, String desc, String imageUrl) {
        Name = name;
        Desc = desc;
        ImageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public String getDesc() {
        return Desc;
    }

    public String getImageUrl() {
        return ImageUrl;
    }
}
