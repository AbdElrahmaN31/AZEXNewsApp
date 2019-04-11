package com.example.myproject.Interface;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {

    private  static Retrofit retrofit=null;

    public static Retrofit grtClint(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create() )
                    .build();

        }return retrofit;
    }

//     static public Retrofit grtClint() {
//        Gson gson = new GsonBuilder().setLenient().create();
//
////        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
////                .readTimeout(60, TimeUnit.SECONDS)
////                .connectTimeout(60, TimeUnit.SECONDS)
////                .build();
//
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl("https://newsapi.org/")
//                    .addConverterFactory(GsonConverterFactory.create(gson))
////                    .client(okHttpClient)
//                    .build();
//        }
//
//        return retrofit;
//    }

}
