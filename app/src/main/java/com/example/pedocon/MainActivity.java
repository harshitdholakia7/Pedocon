package com.example.pedocon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.pedocon.fragment.aboutUsFragment;
import com.example.pedocon.fragment.contactUsFragment;
import com.example.pedocon.fragment.homeFragment;
import com.example.pedocon.fragment.qrCodeFragment;
import com.example.pedocon.fragment.TandCFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.bottom_nav)BottomNavigationView navigationView;
    Fragment fragment = null;
    FragmentTransaction fragmentTransaction;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragment = new homeFragment();
        manager = getSupportFragmentManager();
        fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLaoyout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        fragmentmethod(fragment);

        navigationView.setOnNavigationItemSelectedListener(naviCustomeListView);
    }

    private void fragmentmethod(Fragment fragment)
    {
        this.fragment = fragment;
        manager = getSupportFragmentManager();
        fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLaoyout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener naviCustomeListView=new BottomNavigationView.OnNavigationItemSelectedListener()
    {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
        {
            switch (menuItem.getItemId())
            {
                case R.id.home:
                    fragment=new homeFragment();
                    fragmentmethod(fragment);
                    break;

                case R.id.about_us:
                    fragment=new aboutUsFragment();
                    fragmentmethod(fragment);
                    break;

                case R.id.qr_code:
                    fragment=new qrCodeFragment();
                    fragmentmethod(fragment);
                    break;

                case R.id.terms_conditions:
                    fragment=new TandCFragment();
                    fragmentmethod(fragment);
                    break;

                case R.id.contact_us:
                    fragment=new contactUsFragment();
                    fragmentmethod(fragment);
                    break;

            }
            return true;
        }
    };

}
