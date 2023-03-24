package com.example.pagging.Di

import com.example.pagging.Utils.ApiLink.Base_Url
import com.example.pagging.retrofit.Retrofitapi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitBase {
    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getRetrofitapi(retrofit: Retrofit): Retrofitapi{
        return retrofit.create(Retrofitapi::class.java)
    }

}