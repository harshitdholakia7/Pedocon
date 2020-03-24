package com.example.pedocon.Model;

import java.security.PrivateKey;

public class DeshboardListModel
{
    private String name;
    private int layout;

    public DeshboardListModel(String name, int layout)
    {
        this.name = name;
        this.layout = layout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }
}
