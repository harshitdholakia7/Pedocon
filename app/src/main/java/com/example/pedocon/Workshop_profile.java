package com.example.pedocon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Workshop_profile extends AppCompatActivity {
    @BindView(R.id.workshoptext)
    TextView workshoptext;
    @BindView(R.id.workshopshare)
    ImageView workshopshare;
    @BindView(R.id.workshopgoing)
    ImageView workshopgoing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop_profile);
        ButterKnife.bind(this);
        workshoptext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Workshop_profile.this,Workshop.class);
                startActivity(intent);
                finish();
            }
        });
        workshopshare.setOnClickListener(new View.OnClickListener() {
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
        workshopgoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Workshop_profile.this);
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
        Intent intent=new Intent(Workshop_profile.this,Workshop.class);
        startActivity(intent);
        finishAffinity();
    }
}
