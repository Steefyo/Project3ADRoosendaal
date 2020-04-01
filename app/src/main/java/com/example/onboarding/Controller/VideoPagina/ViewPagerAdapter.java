package com.example.onboarding.Controller.VideoPagina;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class ViewPagerAdapter extends FragmentStateAdapter {

    private int NUM_VIEWS = 0;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return CardFragment.newInstance(position);
    }

    //dit is het aantal paginas dat gemaakt word.
    public void setN(int N) {
        this.NUM_VIEWS = N;
    }

    //hier word de aantal paginas opgevraagt.
    @Override
    public int getItemCount() {
        return NUM_VIEWS;
    }
}
