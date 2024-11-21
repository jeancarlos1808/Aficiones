package com.jeancarlos1808.aficiones.uifrmanager;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.jeancarlos1808.aficiones.R;
import com.jeancarlos1808.aficiones.fr.tipofutbol.Futbol7;

public class PaginadorTipoFutbol extends FragmentPagerAdapter {

    private final Context mContext;

    public PaginadorTipoFutbol(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @StringRes
    private static final int[] TITULOS = new int[]{
            R.string.tipoFutbol7,
    };

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Futbol7();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TITULOS[position]);
    }
}
