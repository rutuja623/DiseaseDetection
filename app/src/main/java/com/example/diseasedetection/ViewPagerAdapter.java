package com.example.diseasedetection;

//import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    String disease_name;
    public ViewPagerAdapter(@NonNull FragmentManager fm, String disease) {
        super(fm);
        this.disease_name = disease;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new Discription_and_Symptoms(disease_name);

        }else if(position==1){
            return new Causes(disease_name);

        }else{
            return new Prevention_and_treatment(disease_name);
        }
    }

    @Override
    public int getCount() {
        return 3; // no of tabs
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Discription and Symptoms";
        }else if(position==1){
            return "Causes";
        }else{
            return "Prevention and Treatment";
        }
    }
}
