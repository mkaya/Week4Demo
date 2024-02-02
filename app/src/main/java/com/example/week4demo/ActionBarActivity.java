package com.example.week4demo;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        Toolbar myToolBar=findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolBar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Toolbar bottomToolbar = (Toolbar) findViewById(R.id.second_toolbar);
        Menu menu=bottomToolbar.getMenu();
        getMenuInflater().inflate(R.menu.second_toolbar, menu);
        bottomToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menu_item_id = item.getItemId();
                if (menu_item_id == R.id.cut_action) {
                        Toast.makeText(ActionBarActivity.this, "Cut action in toolbar", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //set_bottom_bar();
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.search_action);

        SearchView searchView=(SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast toast=Toast.makeText(getApplicationContext(),"Query Text="+query,Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                Toast toast=Toast.makeText(getApplicationContext(),newText,Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }
        });

        MenuItem shareItem = menu.findItem(R.id.sharewith_action);
        ShareActionProvider myShareActionProvider =(ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        Intent myShareIntent = new Intent(Intent.ACTION_SEND);
        myShareIntent.setType("text/plain");
        myShareIntent.putExtra(Intent.EXTRA_TEXT,"Hello World!");
        // Intent chooser = Intent.createChooser(myShareIntent, "Share via");
        myShareActionProvider.setShareIntent(myShareIntent);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.search_action) {
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.settings_action) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.share_action) {
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.cut_action) {
            Toast toast = Toast.makeText(getApplicationContext(), "Cut Clicked", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        } else if (itemId == R.id.extras_action) {
            Toast toast;
            toast = Toast.makeText(getApplicationContext(), "Extra Clicked", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        } else if (itemId == R.id.extras1_action) {
            Toast toast;
            toast = Toast.makeText(getApplicationContext(), "Extra1 Clicked", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        } else if (itemId == androidx.appcompat.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void HideShow(View view) {
        ActionBar actionBar=getSupportActionBar();
        if(actionBar.isShowing()){
            actionBar.hide();
            ((Button)view).setText("SHOW");
        }
        else{
            actionBar.show();
            ((Button)view).setText("HIDE");
        }
    }
}