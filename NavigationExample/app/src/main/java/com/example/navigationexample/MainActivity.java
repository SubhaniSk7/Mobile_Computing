package com.example.navigationexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        addMenuItemInNavMenuDrawer();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.drawer_camera:
                        menuItem.setChecked(true);
                        displayMessage("Camera selected..");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.drawer_gallery:
                        menuItem.setChecked(true);
                        displayMessage("Gallery selected..");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.drawer_slideshow:
                        menuItem.setChecked(true);
                        displayMessage("SlideShow selected..");
                        drawerLayout.closeDrawers();
                        return true;
                    default:
                        menuItem.setChecked(true);
                        displayMessage("" + menuItem.getTitle());
//                        displayMessage(menuItem.getItemId() + " item selected..");
                        drawerLayout.closeDrawers();
                        return true;
                }
//                return false; commented because Default case in Switch block
            }
        });
    }

    private void addMenuItemInNavMenuDrawer() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);

        Menu menu = navigationView.getMenu();
        for (int i = 0; i < 7; i++) {
            String itemName = "Course " + i;
            MenuItem mi = menu.add(Menu.NONE, i, 1, itemName);// groupId, itemId, Order, title
            mi.setIcon(R.drawable.ic_folder);
        }

        //For SubMenu
        SubMenu submenu = menu.addSubMenu("Registed Courses");
        for (int i = 0; i < 5; i++) {
            String subMenuName = "subMenu " + i;
            submenu.add(Menu.NONE, i, 1, subMenuName).setIcon(R.drawable.ic_folder);
            ;// groupId, itemId, Order, title
        }

        navigationView.invalidate();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        System.out.println("in onPrepareOptionsMenu......");
        return super.onPrepareOptionsMenu(menu);
    }

    private void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    //Menu Icon on Navigation Bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
