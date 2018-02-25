package com.example.aldiros.modul3_aldirostiawan_1202150104;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuAir extends AppCompatActivity {

    private List<Menu> menuList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MenuAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_air);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MenuAdapter(this, menuList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMenuData();

        //membuat mode lansekap dan grid
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
    }

    private void prepareMenuData() {
        String[] water_title = getResources().getStringArray(R.array.water_titles);
        String[] water_detail = getResources().getStringArray(R.array.water_detail);
        String[] water_info = getResources().getStringArray(R.array.water_info);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.water_images);
        //Clear the existing data (to avoid duplication)
        menuList.clear();


        //untuk menampilkan menu secara berurutan
        for(int i=0; i<water_title.length; i++){
            menuList.add(new Menu(sportsImageResources.getResourceId(i,0),water_title[i], water_detail[i], water_info[i]));
        }

        //Recycle the typed array
        sportsImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }
}
