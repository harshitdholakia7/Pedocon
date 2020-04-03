package com.example.pedocon.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pedocon.Interface.RecyclerClick;
import com.example.pedocon.R;
import com.example.pedocon.SponsorsProfile;
import com.example.pedocon.adapter.SponsorAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class PresentingSponsor extends Fragment {
    @BindView(R.id.recylcer_presenting)
    RecyclerView recyclerView_presenting_sponsor;

    Context context;

    public PresentingSponsor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_presenting_sponsor,container,false);
        inint(root);
        return root;
    }
    private void inint(View root) {
        ButterKnife.bind(this,root);
        recyclerView_presenting_sponsor.setLayoutManager(new LinearLayoutManager(recyclerView_presenting_sponsor.getContext(),RecyclerView.HORIZONTAL,false));
        SponsorAdapter adapter=new SponsorAdapter();
        recyclerView_presenting_sponsor.setAdapter(adapter);
        adapter.SetUpInterface(new RecyclerClick() {
            @Override
            public void ClickOne(String Url) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Url));
                startActivity(intent);
            }
            @Override
            public void ClickTwo(String Url) {
                Intent intent =new Intent(getActivity(), SponsorsProfile.class);
                startActivity(intent);
            }
        });
    }
}
