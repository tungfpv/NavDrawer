package com.example.navdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ViewPager2 viewPager2;
    TabLayout mTabLayout;
    ///

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test

        navigationView = findViewById(R.id.navview);
        drawerLayout = findViewById(R.id.drawer);

        viewPager2 = findViewById(R.id.view_pager);
        viewPager2.setAdapter(new MyViewPagerAdapter(this));

        mTabLayout = findViewById(R.id.tabLayout);

        new TabLayoutMediator(mTabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Home");
                        break;
                    case 1:
                        tab.setText("My Profile");
                        break;
                    case 2:
                        tab.setText("Settings");
                        break;

                }

            }
        }).attach();

        //adding customised toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //toggle button
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //when an item is selected from menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        viewPager2.setCurrentItem(0, true);
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                        //close drawer
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.profile:
                        viewPager2.setCurrentItem(1, true);
                        Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
                        //close drawer
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.settings:
                        viewPager2.setCurrentItem(2, true);
                        Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                        //close drawer
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.privacy:
                        Toast.makeText(getApplicationContext(), "Privacy", Toast.LENGTH_SHORT).show();
                        //close drawer
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                }

                return true;
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        navigationView.setCheckedItem(R.id.home);
                        break;
                    case 1:
                        navigationView.setCheckedItem(R.id.profile);
                        break;
                    case 2:
                        navigationView.setCheckedItem(R.id.settings);
                        break;

                }
            }
        });
    }
}