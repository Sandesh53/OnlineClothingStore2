package com.example.onlineclothingstore;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import adapter.ViewPagerAdapter;
import fragments.Fragment_Login;
import fragments.RegisterFragment;


public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.loginfragment(new Fragment_Login(),"LOGIN");
        adapter.loginfragment(new RegisterFragment(),"Register");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}


