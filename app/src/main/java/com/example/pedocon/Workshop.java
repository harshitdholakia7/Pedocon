package com.example.pedocon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Workshop extends AppCompatActivity {
    @BindView(R.id.workshop_profile)
    Button workshop_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);
        ButterKnife.bind(this);
        Intent intent=new Intent(Workshop.this,Workshop_profile.class);
        startActivity(intent);
        finish();
    }
}
