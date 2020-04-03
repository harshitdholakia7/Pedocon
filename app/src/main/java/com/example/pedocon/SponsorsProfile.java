package com.example.pedocon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SponsorsProfile extends AppCompatActivity {
    Integer f1 = 0;
    @BindView(R.id.general_profile_linear_layout)
    LinearLayout general_Profile_Linear_Layout;
    @BindView(R.id.image_view_sponsor_profile)
    ImageView imageViewSponsorProfile;
    @BindView(R.id.plan_text_view)
    TextView planTextView;
    @BindView(R.id.linear_layout_sponsor_profile)
    LinearLayout linearLayoutSponsorProfile;
    @BindView(R.id.linear_layout_sponsor_profile_about_business)
    LinearLayout linearLayoutSponsorProfileAboutBusiness;
    @BindView(R.id.linear_layout_sponsor_profile_general_profile)
    LinearLayout linearLayoutSponsorProfileGeneralProfile;
    @BindView(R.id.linear_layout_general_profile_layout)
    LinearLayout linearLayoutGeneralProfileLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors_profile);
        ButterKnife.bind(this);
        linearLayoutGeneralProfileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (f1 == 0) {
                    general_Profile_Linear_Layout.setVisibility(View.GONE);
                    f1 = 1;
                } else {
                    general_Profile_Linear_Layout.setVisibility(View.VISIBLE);
                    f1 = 0;
                }
            }
        });
    }
}
