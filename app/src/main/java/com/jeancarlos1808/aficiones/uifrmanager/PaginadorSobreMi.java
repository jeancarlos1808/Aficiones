package com.jeancarlos1808.aficiones.uifrmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jeancarlos1808.aficiones.fr.sobremi.foto;

public class PaginadorSobreMi extends FragmentPagerAdapter {

    private final Context mContext;

    public PaginadorSobreMi(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new foto();
            case 1:
                return new nombre();

            default:
                return null;
        }
    }

    @Override
    public int getCount() { return 3; }
}