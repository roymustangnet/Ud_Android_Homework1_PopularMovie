package com.example.android.movie.data;

public class Movie {
    private String mName;
    private String mImgUrl;
    private String mRate;

    public Movie(String name, String imgUrl){
        this.mName = name;
        this.mImgUrl = imgUrl;
    }

    public Movie(String name, String imgUrl, String rate){
        this.mName = name;
        this.mImgUrl = imgUrl;
        this.mRate = rate;
    }

    public String getName(){ return mName; }
    public String getImgUrl(){ return mImgUrl; }
    public String getRate(){ return mRate; }

}
