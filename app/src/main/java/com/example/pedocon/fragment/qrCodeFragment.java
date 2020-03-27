package com.example.pedocon.fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.pedocon.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class qrCodeFragment extends Fragment implements View.OnClickListener
{
    @BindView(R.id.cardview_day1)CardView cardview_day1;
    @BindView(R.id.cardview_day2)CardView cardview_day2;
    @BindView(R.id.cardview_day3)CardView cardview_day3;
    @BindView(R.id.cardview_day4)CardView cardview_day4;

    @BindView(R.id.ly_day1)LinearLayout ly_day1;
    @BindView(R.id.ly_day2)LinearLayout ly_day2;
    @BindView(R.id.ly_day3)LinearLayout ly_day3;
    @BindView(R.id.ly_day4)LinearLayout ly_day4;

    private int f1,f2,f3,f4;
    public qrCodeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        f1=f2=f3=f4=0;
        View view=inflater.inflate(R.layout.fragment_qr_code, container, false);
        ButterKnife.bind(this,view);

        cardview_day1.setOnClickListener(this);
        cardview_day2.setOnClickListener(this);
        cardview_day3.setOnClickListener(this);
        cardview_day4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.cardview_day1:
                if (f1==0)
                {
                    ly_day1.setVisibility(View.VISIBLE);
                    ly_day2.setVisibility(View.GONE);
                    ly_day3.setVisibility(View.GONE);
                    ly_day4.setVisibility(View.GONE);
                    f1=1;
                }
                else
                {
                    ly_day1.setVisibility(View.GONE);
                    f1=f2=f3=f4=0;
                }
                break;

            case R.id.cardview_day2:
                if (f2==0)
                {
                    ly_day2.setVisibility(View.VISIBLE);
                    ly_day1.setVisibility(View.GONE);
                    ly_day3.setVisibility(View.GONE);
                    ly_day4.setVisibility(View.GONE);
                    f2=1;
                }
                else
                {
                    ly_day2.setVisibility(View.GONE);
                    f1=f2=f3=f4=0;
                }
                break;

            case R.id.cardview_day3:
                if (f3==0)
                {
                    ly_day3.setVisibility(View.VISIBLE);
                    ly_day2.setVisibility(View.GONE);
                    ly_day1.setVisibility(View.GONE);
                    ly_day4.setVisibility(View.GONE);
                    f3=1;
                }
                else
                {
                    ly_day3.setVisibility(View.GONE);
                    f1=f2=f3=f4=0;
                }
                break;

            case R.id.cardview_day4:
                if (f4==0)
                {
                    ly_day4.setVisibility(View.VISIBLE);
                    ly_day2.setVisibility(View.GONE);
                    ly_day3.setVisibility(View.GONE);
                    ly_day1.setVisibility(View.GONE);
                    f4=1;
                }
                else
                {
                    ly_day4.setVisibility(View.GONE);
                    f1=f2=f3=f4=0;
                }
                break;
        }
    }
}
