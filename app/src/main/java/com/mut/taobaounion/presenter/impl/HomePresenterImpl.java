package com.mut.taobaounion.presenter.impl;

import com.mut.taobaounion.domain.Categories;
import com.mut.taobaounion.model.API;
import com.mut.taobaounion.presenter.IHomePresenter;
import com.mut.taobaounion.utils.LogUtils;
import com.mut.taobaounion.utils.RetrofitManager;
import com.mut.taobaounion.view.IHomeCallback;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePresenterImpl implements IHomePresenter {
    @Override
    public void getCategories() {
           //加载分类数据
        Retrofit retrofit = RetrofitManager.getInstance().getretrofit();
        API api = retrofit.create(API.class);
        Call<Categories> task = api.getCategories();
        task.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                //数据结果
                int code = response.code();
                LogUtils.d(HomePresenterImpl.this,"result code is -------> "+code+"");
                if(code== HttpURLConnection.HTTP_OK)
                {
                    //请求成功
                    Categories categories = response.body();
                    LogUtils.d(HomePresenterImpl.this," result ----------> "+ categories.toString());
                }
                else{
                    LogUtils.e(HomePresenterImpl.this,"请求失败");
                    //请求失败
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
//加载失败的结果
                LogUtils.e(HomePresenterImpl.this,"请求错误。。。。。"+ t);
            }
        });

    }

    @Override
    public void registerCallback(IHomeCallback callback) {

    }

    @Override
    public void unregisterCallback(IHomeCallback callback) {

    }
}
