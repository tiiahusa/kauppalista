package com.example.kauppalista;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.kauppalista.fragments.FragmentA;
import com.example.kauppalista.fragments.FragmentB;
import com.example.kauppalista.fragments.FragmentC;

public class TabPagerAdapter extends FragmentStateAdapter {


    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new FragmentC();
            case 1:
                return new FragmentB();
            case 2:
                return new FragmentA();
            default:
                return new FragmentC();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
