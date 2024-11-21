package com.jeancarlos1808.aficiones;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeancarlos1808.aficiones.databinding.ActivitySobreMiBinding;
import com.jeancarlos1808.aficiones.uifrmanager.PaginadorSobreMi;

public class SobreMi extends AppCompatActivity {

    private ActivitySobreMiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySobreMiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PaginadorSobreMi PaginadorSobreMi = new PaginadorSobreMi(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;

        viewPager.setAdapter(PaginadorSobreMi);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.favButton) {

            int currentItem = binding.viewPager.getCurrentItem();
            Fragment currentFragment = getSupportFragmentManager().getFragments().get(currentItem);

            String fragmentName = "";
            if (currentFragment != null) {
                fragmentName = currentFragment.getClass().getSimpleName();
            } else {
                fragmentName = "Fragmento no disponible";
            }

            Toast toast = Toast.makeText(this, "Ahora mismo estas viendo mi '"+ fragmentName +"' de la parte de 'Sobre Mi'. ", Toast.LENGTH_SHORT);
            toast.show();

        }
        if (id == R.id.aficionesButton) {
            Intent intent = new Intent(SobreMi.this, Aficiones.class);
            startActivity(intent);
        }
        if (id == R.id.aboutMeButton) {
            Intent intent = new Intent(SobreMi.this, SobreMi.class);
            startActivity(intent);
        }
        if (id == R.id.myCodeButton) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://github.com/Antonio-jb"));
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}