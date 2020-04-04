package com.example.pedocon.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pedocon.Event_Details;
import com.example.pedocon.FandBPartners;
import com.example.pedocon.Model.DeshboardListModel;
import com.example.pedocon.MySchedule;
import com.example.pedocon.OrganizationCommiittee;
import com.example.pedocon.R;
import com.example.pedocon.Schedule;
import com.example.pedocon.Speakers;
import com.example.pedocon.Sponsors;
import com.example.pedocon.Traders;
import com.example.pedocon.Workshop;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private ArrayList<DeshboardListModel> deshboardListModels;
    Context context;
    public AdapterRecyclerView(ArrayList<DeshboardListModel> view_model, Context context)
    {
        this.deshboardListModels=view_model;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view;
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        view =layoutInflater.inflate(R.layout.deshboardlist,parent,false);
        return new DeshboardListHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        DeshboardListHolder deshboardListHolder= (DeshboardListHolder) holder;
        deshboardListHolder.name_list.setText(deshboardListModels.get(position).getName());
        deshboardListHolder.img_list.setImageResource(deshboardListModels.get(position).getLayout());
        deshboardListHolder.deshboardlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                final Intent intent;
                if (position==0)
                {
                    intent = new Intent(context, Event_Details.class);
                }
                else if (position==1)
                {
                    intent = new Intent(context, Schedule.class);
                }
                else if (position==2)
                {
                    intent = new Intent(context, Speakers.class);
                }
                else if (position==3)
                {
                    intent =  new Intent(context, Workshop.class);
                }
                else if (position==4)
                {
                    intent =  new Intent(context, MySchedule.class);
                }
                else if (position==5)
                {
                    intent =  new Intent(context, FandBPartners.class);
                }
                else if (position==6)
                {
                    intent =  new Intent(context, Traders.class);
                }
                else if (position==7)
                {
                    intent =  new Intent(context, OrganizationCommiittee.class);
                }
                else
                {
                    intent =  new Intent(context, Sponsors.class);
                }
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return deshboardListModels.size();
    }

    class DeshboardListHolder extends RecyclerView.ViewHolder
    {
        @Nullable
        @BindView(R.id.img_list)ImageView img_list;
        @Nullable
        @BindView(R.id.name_list)TextView name_list;
        @BindView(R.id.deshboardlist)LinearLayout deshboardlist;
        public DeshboardListHolder(@NonNull View itemView)
        {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
