package com.wordie.leaderboard.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    private static String URL = "https://gadsapi.herokuapp.com";
    private static Retrofit retrofit;

    // Create logger
    private static HttpLoggingInterceptor logger =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    // Create OkHttp Client
    private static OkHttpClient.Builder okHttp =
            new OkHttpClient.Builder().addInterceptor(logger);

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build());

    OkHttpClient client = okHttp
            .addInterceptor(logger)
            .connectTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .readTimeout(180, TimeUnit.SECONDS)
            .build();

    public static void changeApiBaseUrl(String newApiUrl) {
        URL = newApiUrl;

        builder = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp.build());
    }

    public static <S> S buildService(Class<S> serviceType) {

        retrofit = builder.build();
        return retrofit.create(serviceType);
    }
}
