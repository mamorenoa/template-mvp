package com.template.injector.module;

import android.app.Application;

import com.template.R;
import com.template.data.api.ConfigEndpoint;
import com.template.data.api.services.APIService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    @Named("setParams")
    public ConfigEndpoint provideNetworkConfig(Application context) {
        ConfigEndpoint configEndpoint = new ConfigEndpoint();
        configEndpoint.setBaseUrl(context.getResources().getString(R.string.HOST));
        return configEndpoint;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient().newBuilder();
        OkHttpClient client = clientBuilder.build();
        return client;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofitClient(OkHttpClient client, @Named("setParams") ConfigEndpoint configEndpoint) {
        Retrofit retrofitClient = new Retrofit.Builder()
                .baseUrl(configEndpoint.getBaseUrl() + configEndpoint.getLanguage() + configEndpoint.getVersion())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofitClient;
    }

    @Provides
    @Singleton
    public APIService provideApiService(Retrofit retrofit) {
        APIService apiService = retrofit.create(APIService.class);
        return apiService;
    }
}

