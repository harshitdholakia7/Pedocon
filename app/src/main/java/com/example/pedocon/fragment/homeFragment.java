package com.example.pedocon.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pedocon.Model.DeshboardListModel;
import com.example.pedocon.Model.SponsorImgListModel;
import com.example.pedocon.R;
import com.example.pedocon.adapter.AdapterRecyclerView;
import com.example.pedocon.adapter.SlidingImageAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class homeFragment extends Fragment
{
    @BindView(R.id.recyclerView_deshbordList)RecyclerView recyclerView_deshbordList;
    @BindView(R.id.viewPager)ViewPager mPager;
    @BindView(R.id.preSponsor_Viewpager)ViewPager preSponsor_Viewpager;
    @BindView(R.id.goldSponsor_Viewpager)ViewPager goldSponsor_Viewpager;
    @BindView(R.id.appdevlop_Viewpager)ViewPager appdevlop_Viewpager;

    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<Integer> ImagesArray = new ArrayList<>();
    private ArrayList<SponsorImgListModel> sponsorListModels;


    public homeFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);

        ArrayList<DeshboardListModel> deshboardListModels = new ArrayList<>();
        sponsorListModels = new ArrayList<>();

        deshboardListModels.add(new DeshboardListModel("Event Details",R.drawable.event_icon));
        deshboardListModels.add(new DeshboardListModel("Schedule",R.drawable.schedule_icon));
        deshboardListModels.add(new DeshboardListModel("Speaker",R.drawable.speaker_icon));
        deshboardListModels.add(new DeshboardListModel("Workshop",R.drawable.workshop_icon));
        deshboardListModels.add(new DeshboardListModel("My Schedule",R.drawable.my_schedule_icon));
        deshboardListModels.add(new DeshboardListModel("F & B",R.drawable.ic_launcher_background));
        deshboardListModels.add(new DeshboardListModel("Traders",R.drawable.traders_icon));
        deshboardListModels.add(new DeshboardListModel("Organization Committee",R.drawable.ic_launcher_background));
        deshboardListModels.add(new DeshboardListModel("Sponsors",R.drawable.sponsor_icon));

        sponsorListModels.add(new SponsorImgListModel(R.drawable.d1));
        sponsorListModels.add(new SponsorImgListModel(R.drawable.d2));
        sponsorListModels.add(new SponsorImgListModel(R.drawable.d3));
        sponsorListModels.add(new SponsorImgListModel(R.drawable.d4));
        sponsorListModels.add(new SponsorImgListModel(R.drawable.d5));


        init();

        recyclerView_deshbordList.setLayoutManager(new GridLayoutManager(getContext(),3));
        AdapterRecyclerView deshboardAdapter = new AdapterRecyclerView(deshboardListModels,0);
        recyclerView_deshbordList.setAdapter(deshboardAdapter);

        return view;
    }

    private void init()
    {
        for (int i = 0; i < sponsorListModels.size(); i++)
            ImagesArray.add(sponsorListModels.get(i).getLayout());

        mPager.setAdapter(new SlidingImageAdapter(getContext(), ImagesArray));
        preSponsor_Viewpager.setAdapter(new SlidingImageAdapter(getContext(), ImagesArray));
        goldSponsor_Viewpager.setAdapter(new SlidingImageAdapter(getContext(), ImagesArray));
        appdevlop_Viewpager.setAdapter(new SlidingImageAdapter(getContext(), ImagesArray));

        NUM_PAGES = sponsorListModels.size();

        final Handler handler = new Handler();
        final Runnable Update = () -> {
            if (currentPage == NUM_PAGES) {
                currentPage = 0;
            }
            mPager.setCurrentItem(currentPage, true);
            preSponsor_Viewpager.setCurrentItem(currentPage, true);
            goldSponsor_Viewpager.setCurrentItem(currentPage, true);
            appdevlop_Viewpager.setCurrentItem(currentPage, true);
            currentPage++;
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2000, 4000);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        preSponsor_Viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        goldSponsor_Viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        appdevlop_Viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }

}
