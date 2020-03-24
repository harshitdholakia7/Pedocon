package com.example.pedocon.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pedocon.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class contactUsFragment extends Fragment
{
    public contactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_contact_us, container, false);
        ButterKnife.bind(this,view);
        // Inflate the layout for this fragment
        return view;
    }
}
