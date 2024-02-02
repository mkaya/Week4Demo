package com.example.week4demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoToActionBar(View view) {
        startActivity(new Intent(this, ActionBarActivity.class));
    }

    public void GoToRecyclerView(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));

    }
}