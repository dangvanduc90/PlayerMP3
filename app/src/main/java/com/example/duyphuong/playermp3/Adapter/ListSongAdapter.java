package com.example.duyphuong.playermp3.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duyphuong.playermp3.Activity.MainActivity;
import com.example.duyphuong.playermp3.Model.SongModel;
import com.example.duyphuong.playermp3.R;

import java.util.ArrayList;

public class ListSongAdapter extends BaseAdapter{

    private ArrayList<SongModel> arrayList = new ArrayList<>();
    private Context context;
    public ListSongAdapter (Context context, ArrayList<SongModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View row = layoutInflater.inflate(R.layout.list_songs_item,parent,false);

        TextView tvSongName = row.findViewById(R.id.tvSongName);
        final CheckBox checkBox = (CheckBox) row.findViewById(R.id.cb);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    MainActivity.arrSongFav.add(arrayList.get(position));
                }
            }
        });
        tvSongName.setText(arrayList.get(position).title);
        return row;
    }
}
