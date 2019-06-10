package com.yuruiyin.sample.adapter;

import android.content.Context;
import android.graphics.Color;
import androidx.viewpager.widget.ViewPager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;


import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgePagerTitleView;

import java.util.List;

/**
 * Created by yuruiyin on 2017/9/22.
 */

public class CustomIndicatorAdapter extends CommonNavigatorAdapter {

    private ViewPager mViewPager;

    private Data mData;

    /**
     * 普通的白底tab需要的data
     */
    public static class Data {
        public List<String> tabTiles;
        public float lineWidthDp;
        public float lineHeightDp;
        public float lineRoundRadiusDp;
        public int lineColor;
        public float lineYOffsetDp;

        public float titleTextSizeDp;
        public int titleNormalColor;
        public int titleSelectedColor;

        public Data(List<String> tabTiles) {
            // 设置默认值
            this.tabTiles = tabTiles;
            this.lineWidthDp = -1; //说明下划线长度自适应
            this.lineHeightDp = 2.5f;
            this.lineRoundRadiusDp = 0;
            this.lineColor = Color.parseColor("#3F51B5");
            this.lineYOffsetDp = 0;

            this.titleTextSizeDp = 14;
            this.titleNormalColor = Color.parseColor("#aaaaaa");
            this.titleSelectedColor = Color.parseColor("#3F51B5");
        }
    }

    public CustomIndicatorAdapter(ViewPager viewPager, Data data) {
        mViewPager = viewPager;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.tabTiles == null ? 0 : mData.tabTiles.size();
    }

    @Override
    public IPagerTitleView getTitleView(Context context, int position) {
        BadgePagerTitleView badgePagerTitleView = new BadgePagerTitleView(context);

        SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
        simplePagerTitleView.setTextSize(mData.titleTextSizeDp);
        simplePagerTitleView.setText(getTitle(position));
        simplePagerTitleView.setNormalColor(mData.titleNormalColor);
        simplePagerTitleView.setSelectedColor(mData.titleSelectedColor);
        simplePagerTitleView.setOnClickListener(v -> mViewPager.setCurrentItem(position));
//        simplePagerTitleView.setPadding(UIUtil.dip2px(context, 20), 0, UIUtil.dip2px(context, 20), 0);
        badgePagerTitleView.setInnerPagerTitleView(simplePagerTitleView);

        return badgePagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator indicator = new LinePagerIndicator(context);
        indicator.setLineHeight(UIUtil.dip2px(context, mData.lineHeightDp));
        if(mData.lineWidthDp != -1) {
            indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
            indicator.setLineWidth(UIUtil.dip2px(context, mData.lineWidthDp));
        }
        indicator.setRoundRadius(UIUtil.dip2px(context, mData.lineRoundRadiusDp));
        indicator.setStartInterpolator(new AccelerateInterpolator());
        indicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
        indicator.setColors(mData.lineColor);
        indicator.setYOffset(UIUtil.dip2px(context, mData.lineYOffsetDp));
        return indicator;
    }

    @Override
    public float getTitleWeight(Context context, int index) {
        return 1.0f;
    }

    public String getTitle(int position) {
        return mData.tabTiles.get(position);
    }
}
