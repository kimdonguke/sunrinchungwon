package com.example.sunrinchungwon;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.sunrinchungwon.Adapters.ContentsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private Context mContext;
    private ViewPager mViewPager;
    private ContentsPagerAdapter mContentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        mTabLayout = (TabLayout) findViewById(R.id.layout_tab);
        mViewPager = (ViewPager) findViewById(R.id.pager_content);

        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("홈")));

        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("게임")));

        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("영화")));

        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("도서")));

        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("뉴스스탠드")));

        mContentPagerAdapter = new ContentsPagerAdapter(

                getSupportFragmentManager(), mTabLayout.getTabCount());

        mViewPager.setAdapter(mContentPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // ㅎ...흥 오버라이드 하던가 말던가!
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // ㅎ...흥 오버라이드 하던가 말던가!
            }
        });
    }

    private View createTabView(String tabName) {

        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);

        TextView txt_name = (TextView) tabView.findViewById(R.id.txt_name);

        txt_name.setText(tabName);

        return tabView;
    }
}
