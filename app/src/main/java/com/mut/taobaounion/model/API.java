package com.mut.taobaounion.model;

import com.mut.taobaounion.domain.Categories;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("discovery/categories")
    Call<Categories> getCategories();

}
