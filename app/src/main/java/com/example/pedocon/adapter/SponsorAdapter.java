package com.example.pedocon.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pedocon.Interface.RecyclerClick;
import com.example.pedocon.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SponsorAdapter extends RecyclerView.Adapter<SponsorAdapter.DemoViewHolder> {

    private RecyclerClick recyclerClick;
    public void SetUpInterface(RecyclerClick recyclerClick){
        this.recyclerClick=recyclerClick;

    }
    @NonNull
    @Override
    public SponsorAdapter.DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.list_view,parent,false);
        return new DemoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder holder, int position) {
        holder.btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerClick.ClickTwo("");
            }
        });
        holder.SponsorImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerClick.ClickOne("https://www.google.com/");
            }
        });
    }
    @Override
    public int getItemCount() {
        return 1;
    }

    class DemoViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.view)
        TextView btn_view;

        @BindView(R.id.circle_image)
        ImageView SponsorImageView;

        DemoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
