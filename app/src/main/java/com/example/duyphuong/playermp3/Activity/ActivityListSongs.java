package com.example.duyphuong.playermp3.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

import com.example.duyphuong.playermp3.Adapter.ListSongAdapter;
import com.example.duyphuong.playermp3.Model.SongModel;
import com.example.duyphuong.playermp3.R;

import java.util.ArrayList;
import java.util.function.ToLongBiFunction;

public class ActivityListSongs extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Toolbar toolbar;
    private ListView lvListSong;
    private EditText inputSearch;
    private ArrayList data;
    private ArrayList dataNew;
    private ListSongAdapter listSongAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_songs);
        loadControls();
        loadEvents();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    private void loadEvents() {
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String keyword = editable.toString();
//                String keyword = edtKeyword.getText().toString().trim();
                int text_length = keyword.length();
                ArrayList data = MainActivity.arrSong;

                dataNew.clear();
                if (text_length > 0) {
                    for (int i = 0; i < data.size(); i++) {

                        SongModel mCongViec = (SongModel) data.get(i);

                        if (mCongViec.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                            dataNew.add(mCongViec);
                        }
                    }
                } else {
                    dataNew.addAll(data);
                }
                listSongAdapter = new ListSongAdapter(ActivityListSongs.this, dataNew);
                lvListSong.setAdapter(listSongAdapter);
            }
        });
    }

    private void loadControls() {
        lvListSong = findViewById(R.id.lvListsong);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        toolbar = findViewById(R.id.toolbarListSongs);
            toolbar.setTitle("Danh sach nhac");
            toolbar.setNavigationIcon(R.drawable.back);
            setSupportActionBar(toolbar);

        data =  MainActivity.arrSong;
        dataNew = new ArrayList();

        // CHOICE_MODE_NONE: Không cho phép lựa chọn (Mặc định).
        // ( listView.setItemChecked(..) không làm việc với CHOICE_MODE_NONE).
        // CHOICE_MODE_SINGLE: Cho phép một lựa chọn.
        // CHOICE_MODE_MULTIPLE: Cho phép nhiều lựa chọn.
        // CHOICE_MODE_MULTIPLE_MODAL: Cho phép nhiều lựa chọn trên Modal Selection Mode.
        lvListSong.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listSongAdapter = new ListSongAdapter(this, data);
        lvListSong.setAdapter(listSongAdapter);
        lvListSong.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("id", position);

        setResult(RESULT_OK, intent);
        finish();
    }
}
