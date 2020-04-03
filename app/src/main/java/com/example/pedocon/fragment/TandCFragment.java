package com.example.pedocon.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.pedocon.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TandCFragment extends Fragment
{
    @BindView(R.id.webview)WebView webView;
    public TandCFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_t_and_c, container, false);
        ButterKnife.bind(this,view);

        webView.loadUrl("http://pedocon2020.com/TermsAndConditions.aspx");

        return view;
    }
}
