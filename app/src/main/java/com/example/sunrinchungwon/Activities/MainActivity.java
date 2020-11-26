package com.example.sunrinchungwon.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.sunrinchungwon.Adapters.ContentsPagerAdapter;
import com.example.sunrinchungwon.R;
import com.example.sunrinchungwon.items.User;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private Context mContext;
    private ViewPager mViewPager;
    private ContentsPagerAdapter mContentPagerAdapter;
    public static User user;
    SharedPreferences sharedPreferences;
    private FirebaseAuth mAuth ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("mainActivity","created");
        mContext = getApplicationContext();
        mTabLayout = (TabLayout) findViewById(R.id.layout_tab);
        mViewPager = (ViewPager) findViewById(R.id.pager_content);
        sharedPreferences=getPreferences(MODE_PRIVATE);

        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("등록된청원")));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("답변완료")));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("청원 등록")));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("알람")));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("환경 설정")));

        mContentPagerAdapter = new ContentsPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(mContentPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mAuth = FirebaseAuth.getInstance();

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
