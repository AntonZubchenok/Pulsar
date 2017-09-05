package com.example.anduser.pulsar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigation_drawer_view)
    NavigationView navigationView;

    private ActionBarDrawerToggle drawerToggle;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            fragmentManager = getSupportFragmentManager();
        }

        setSupportActionBar(toolbar);
        drawerToggle = setupDrawerToggle();
        drawerLayout.addDrawerListener(drawerToggle);
        setupDrawerListener(navigationView);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private void setupDrawerListener(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        handleItemSelection(menuItem);
                        return true;
                    }
                });

    }

    private void handleItemSelection(MenuItem menuItem) {
        Fragment fragment;
        String tag;
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }

//        switch (menuItem.getItemId()) {
//
//        case R.id.nav_show_card:
//            tag = SearchFragment.TAG;
//            fragment = fragmentManager.findFragmentByTag(tag);
//            if (fragment == null) {
//                fragment = SearchFragment.newInstance();
//            }
//            break;
//
//        default:
//            throw new IllegalStateException("Navigation Drawer: no handling implementation for menu item");
//        }
//
//        activityUtils.addFragmentToActivity(fragmentManager, fragment, R.id.cont_main, tag);

        menuItem.setChecked(true);
        drawerLayout.closeDrawers();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    }
}
