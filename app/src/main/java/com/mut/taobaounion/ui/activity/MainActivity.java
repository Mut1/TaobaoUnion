package com.mut.taobaounion.ui.activity;
/**
* @copyright : mut
*
* createTime : 2020-02-23 
*
* author : mut
*
**/
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mut.taobaounion.R;
import com.mut.taobaounion.base.BaseFragment;
import com.mut.taobaounion.ui.fragment.HomeFragment;
import com.mut.taobaounion.ui.fragment.RedPacketFragment;
import com.mut.taobaounion.ui.fragment.SearchFragment;
import com.mut.taobaounion.ui.fragment.SelectedFragment;
import com.mut.taobaounion.utils.LogUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.main_navigation_bar)
    BottomNavigationView navigationView;
    private HomeFragment mHomeFragment;
    private SelectedFragment mSelectedFragment;
    private RedPacketFragment mRedPacketFragment;
    private SearchFragment mSearchFragment;
    private FragmentManager mFm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragments();
        initListener();
    }

    private void initFragments() {

        mHomeFragment = new HomeFragment();
        mSelectedFragment = new SelectedFragment();
        mRedPacketFragment = new RedPacketFragment();
        mSearchFragment = new SearchFragment();

        mFm = getSupportFragmentManager();
        switchFragment(mHomeFragment);
    }

    private void initListener() {
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
             //   Log.d(TAG, "title ------>" + item.getTitle() + "id ---------->" + item.getItemId());
                if (item.getItemId() == R.id.home) {
                    switchFragment(mHomeFragment);
                    LogUtils.d(this,"切换到首页");
                } else if (item.getItemId() == R.id.selected) {
                    switchFragment(mSelectedFragment);
                    LogUtils.d(this,"切换到精选");
                } else if (item.getItemId() == R.id.red_packet) {
                    switchFragment(mRedPacketFragment);
                    LogUtils.d(this,"切换到特惠");
                } else if (item.getItemId() == R.id.search) {
                    switchFragment(mSearchFragment);
                    LogUtils.d(this,"切换到搜索");
                }
                return true;
            }
        });
    }

    private void switchFragment(BaseFragment target) {


        FragmentTransaction transaction = mFm.beginTransaction();
        transaction.replace(R.id.main_page_container,target);
        transaction.commit();



    }


}
