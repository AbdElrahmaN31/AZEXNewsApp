package com.example.myproject.Interface;

import com.example.myproject.Models.NewsModel;

import retrofit2.http.GET;

public interface APIInterface {

    @GET("v2/top-headlines?country=eg&category=business&apiKey=ccc528e7583947ffa204212e9bf8ab1a")
    retrofit2.Call<NewsModel> getbusiness();

    @GET("v2/top-headlines?country=eg&category=entertainment&apiKey=41e8381b11fb4b9f8eb90b7f9a1eada0")
    retrofit2.Call<NewsModel> getentertainment();

    @GET("v2/top-headlines?country=eg&category=health&apiKey=ccc528e7583947ffa204212e9bf8ab1a")
    retrofit2.Call<NewsModel> gethealth();

    @GET("v2/top-headlines?country=eg&category=science&apiKey=ccc528e7583947ffa204212e9bf8ab1a")
    retrofit2.Call<NewsModel> getscience();

    @GET("v2/top-headlines?country=eg&category=sport&apiKey=ccc528e7583947ffa204212e9bf8ab1a")
    retrofit2.Call<NewsModel> getsports();

    @GET("v2/top-headlines?country=eg&category=technology&apiKey=ccc528e7583947ffa204212e9bf8ab1a")
    retrofit2.Call<NewsModel> gettechnology();

}
