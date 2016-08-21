package com.example.jing.seventhelement.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {

    private static HttpClient mInstance;
    private Retrofit singleton;

    public static HttpClient getIns(String base_url) {
        if (mInstance == null) {
            synchronized (HttpClient.class) {
                if (mInstance == null) mInstance = new HttpClient(base_url);
            }
        }
        return mInstance;
    }

    public HttpClient(String BASE_URL) {

        singleton = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(OKHttpHelper.create())
                .build();
    }

    public <T> T createService(Class<T> clz) {
        return singleton.create(clz);
    }
}
