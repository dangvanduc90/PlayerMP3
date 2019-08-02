package com.example.duyphuong.playermp3.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.duyphuong.playermp3.Activity.MainActivity;
import com.example.duyphuong.playermp3.Adapter.ListSongFavAdapter;
import com.example.duyphuong.playermp3.R;

import java.util.ArrayList;

public class FavActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {

    ListView lvListSong;
    private ArrayList data;
    private ListSongFavAdapter listSongAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);

        loadControls();
        loadEvents();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    private void loadControls() {
        lvListSong = findViewById(R.id.lvListSong);

        toolbar = findViewById(R.id.toolbarListSongs);
        toolbar.setTitle("Danh sach nhac yêu thích");
        toolbar.setNavigationIcon(R.drawable.back);
        setSupportActionBar(toolbar);

        data =  MainActivity.arrSongFav;
        listSongAdapter = new ListSongFavAdapter(this, data);
        lvListSong.setAdapter(listSongAdapter);
        lvListSong.setOnItemClickListener(this);
    }

    private void loadEvents() {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("id", position);

        setResult(RESULT_OK, intent);
        finish();
    }
}
