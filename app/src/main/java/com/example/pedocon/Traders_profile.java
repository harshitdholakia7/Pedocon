package com.example.pedocon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Traders_profile extends AppCompatActivity {
    @BindView(R.id.tradertext)
    TextView tradertext;
    @BindView(R.id.tradershare)
    ImageView tradershare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traders_profile);
        ButterKnife.bind(this);
        tradertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Traders_profile.this,Traders.class);
                startActivity(intent);
                finish();
            }
        });
        tradershare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody="Your body here";
                String shareSub="Your Subject here";
                intent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(intent,"Share using"));
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Traders_profile.this,Traders.class);
        startActivity(intent);
        finishAffinity();
    }
}
