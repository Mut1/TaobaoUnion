package com.mut.taobaounion.presenter;

import com.mut.taobaounion.view.IHomeCallback;

public interface IHomePresenter  {
    /**
    * @copyright : mut
    *
    * createTime : 2020-02-24
    * 获取商品分类
    * author : mut
    *
    **/
    void getCategories( );
    //注册UI通知接口
    void registerCallback(IHomeCallback callback);
    //取消UI通知接口
    void unregisterCallback(IHomeCallback callback);
}
