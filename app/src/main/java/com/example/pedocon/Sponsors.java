package com.example.pedocon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.pedocon.fragment.AppDevelopedBy;
import com.example.pedocon.fragment.BgtPresenting;
import com.example.pedocon.fragment.GoldSponsor;
import com.example.pedocon.fragment.PresentingSponsor;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Sponsors extends AppCompatActivity {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);
        ButterKnife.bind(this);
        CustomPageAdapter customPageAdapter=new CustomPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(customPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    class CustomPageAdapter extends FragmentStatePagerAdapter {

        public CustomPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment;
            if (position==0){
                fragment = new PresentingSponsor();
            }else if (position==1){
                fragment = new GoldSponsor();
            }else if (position==2){
                fragment = new AppDevelopedBy();
            }else {
                fragment=new BgtPresenting();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String name;
            if (position==0){
                name="Presenting Sponsor";
            }else if (position==1){
                name="Gold Sponsor";
            }else if(position==2){
                name="App Developed By";
            }else{
                name="Bgt 2.0 Presenting";
            }
            return name;
        }
    }

}
