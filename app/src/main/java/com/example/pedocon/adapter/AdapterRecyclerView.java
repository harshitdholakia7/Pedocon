package com.example.pedocon.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pedocon.Model.DeshboardListModel;
import com.example.pedocon.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private ArrayList<DeshboardListModel> deshboardListModels;
    private int pos;
    public AdapterRecyclerView(ArrayList<DeshboardListModel> view_model, float position)
    {
        this.deshboardListModels=view_model;
        pos= (int) position;
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
        public DeshboardListHolder(@NonNull View itemView)
        {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
