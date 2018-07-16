package com.yuruiyin.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.yuruiyin.sample.adapter.CustomIndicatorAdapter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.magicIndicator)
    MagicIndicator mIndicator;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        mViewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));

        // 初始化tab
        List<String> tabTitles = new ArrayList<>();
        tabTitles.add("tab_1");
        tabTitles.add("tab_2");
        tabTitles.add("tab_3");
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setScrollPivotX(0.65f);
        CustomIndicatorAdapter.Data data = new CustomIndicatorAdapter.Data(tabTitles);
        commonNavigator.setAdapter(new CustomIndicatorAdapter(mViewPager, data));
        commonNavigator.setAdjustMode(true);
        mIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mIndicator, mViewPager);
        mIndicator.onPageSelected(mViewPager.getCurrentItem());
    }

    class MyPageAdapter extends FragmentPagerAdapter {

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return MyListFragment.getInstance(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
