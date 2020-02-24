package com.mut.taobaounion.ui.fragment;

import com.mut.taobaounion.R;
import com.mut.taobaounion.base.BaseFragment;
import com.mut.taobaounion.domain.Categories;
import com.mut.taobaounion.presenter.impl.HomePresenterImpl;
import com.mut.taobaounion.view.IHomeCallback;

public class HomeFragment extends BaseFragment implements IHomeCallback {


    private HomePresenterImpl mHomePresenter;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initPresenter() {
        //创建Presenter
        mHomePresenter = new HomePresenterImpl();
        mHomePresenter.registerCallback(this);
    }

    @Override
    protected void loadData() {

        //加载数据
        mHomePresenter.getCategories();
    }

    @Override
    public void onCategoriesLoaded(Categories categories) {
        //加载的数据就会从这里回来
    }

    @Override
    protected void release() {
        //释放资源
        if (mHomePresenter != null) {
            mHomePresenter.unregisterCallback(this);
            //取消回调注册
        }
    }
}
