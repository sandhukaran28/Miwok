package com.example.miwok;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
private Context context;
    private String  titles[]=new String[]{"Numbers","Colors","Family","Phrases"};
    public CategoryAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return new NumberFragment();
        else if(position==1)
        {
            return new ColorFragment();
        }
        else if(position==2)
            return new FamilyFragment();
        else if(position==3)
            return new PhrasesFragment();
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
