package com.example.week4demo;

import android.view.View;

public interface RecyclerItemClickListener {
    public void onItemClick(View v, int position);
    public void onItemLongClick(View v, int position);
}
