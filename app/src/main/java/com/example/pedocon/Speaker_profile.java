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

public class Speaker_profile extends AppCompatActivity {
    @BindView(R.id.speakertext)
    TextView speakertext;
    @BindView(R.id.speakershare)
    ImageView speakershare;
    @BindView(R.id.speakergoing)
    ImageView speakergoing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_profile);
        ButterKnife.bind(this);
        speakertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Speaker_profile.this,Speakers.class);
                startActivity(intent);
                finish();
            }
        });
        speakershare.setOnClickListener(new View.OnClickListener() {
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
        speakergoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Speaker_profile.this);
                //Yes Button
                builder.setPositiveButton("Yes,Cancel it.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                LayoutInflater inflater = getLayoutInflater();
                View dialoglayout = inflater.inflate(R.layout.workshopshare, null);

                builder.setView(dialoglayout);
                builder.show();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Speaker_profile.this,Workshop.class);
        startActivity(intent);
        finishAffinity();
    }
}
