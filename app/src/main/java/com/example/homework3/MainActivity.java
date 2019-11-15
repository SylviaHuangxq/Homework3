package com.example.homework3;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.homework3.fragments.BreedRecyclerFragment;
import com.example.homework3.fragments.FavRecyclerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // I want there to be a Fragment in the slot from the start
        Fragment fragment = new BreedRecyclerFragment();
        swapFragment(fragment);

        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // menuItem = the item on the bottom nav view that was selected
                // The id's here belong to the items in the menu of the BottomnNavigationView
                // The menu is chunked out as bottom_nav_menu.xml in the res > menu folder
                if (menuItem.getItemId() == R.id.navigation_search) {
                    Fragment fragment = new BreedRecyclerFragment();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.navigation_fav) {
                    Fragment fragment = new FavRecyclerFragment();
                    swapFragment(fragment);
                    return true;
                }
                return false;
            }
        });
    }




    private void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_slot, fragment);
        fragmentTransaction.commit();
    }



/*    @Override
    public void onFragmentInteraction(String string) {
        Toast.makeText(this, "Hello! I have come from the fragment. Message: " + string, Toast.LENGTH_SHORT).show();
    }
*/


    public void showCoolMessage(String string) {
        Toast.makeText(this, "wow you are so " + string, Toast.LENGTH_SHORT).show();

    }
}
