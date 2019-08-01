package com.example.duyphuong.playermp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.duyphuong.playermp3.Activity.MainActivity;
import com.example.duyphuong.playermp3.Adapter.ListSongAdapter;

import java.util.ArrayList;

public class FavActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {

    ListView lvListSong;
    private ArrayList data;
    private ListSongAdapter listSongAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);

        loadControls();
        loadEvents();
    }

    private void loadControls() {
        lvListSong = findViewById(R.id.lvListSong);

        data =  MainActivity.arrSongFav;
        listSongAdapter = new ListSongAdapter(this, data);
        lvListSong.setAdapter(listSongAdapter);
        lvListSong.setOnItemClickListener(this);
    }

    private void loadEvents() {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
